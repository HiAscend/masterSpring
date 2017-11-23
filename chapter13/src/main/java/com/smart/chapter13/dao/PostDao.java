package com.smart.chapter13.dao;

import com.smart.chapter13.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.List;

/**
 * PostDao
 *
 * @author ascend
 * @date 2017/11/23 11:36.
 */
@Repository
public class PostDao {
    private JdbcTemplate jdbcTemplate;
    private LobHandler lobHandler;
    // 主键值产生器
    private DataFieldMaxValueIncrementer dataFieldMaxValueIncrementer;

    public void getNaiveConn() {
        try {
            Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            conn = jdbcTemplate.getNativeJdbcExtractor().getNativeConnection(conn);
            // 获取之后可以进行类型转换
//            OracleConnection oconn = (OracleConnection) conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPost(Post post) {
        String sql = "INSERT INTO t_post(post_id, user_id, post_text, post_attach) VALUES (?,?,?,?)";
        jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            @Override
            protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                // 获取下一个主键值
                ps.setInt(1, dataFieldMaxValueIncrementer.nextIntValue());
                ps.setInt(2, post.getUserId());
                // 3、设置CLOB字段
                lobCreator.setClobAsString(ps, 3, post.getPostText());
                // 4、设置BLOB字段
                lobCreator.setBlobAsBytes(ps, 4, post.getPostAttach());
            }
        });
    }

    /**
     * 以块数据方式读取LOB数据
     *
     * @param userId int
     * @return List
     */
    public List<Post> getAttachs(int userId) {
        String sql = "SELECT post_id, post_attach FROM t_post WHERE user_id=? AND post_attach IS NOT NULL ";
        return jdbcTemplate.query(sql, new Object[]{userId}, new int[]{Types.INTEGER}, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                int postId = rs.getInt(1);
                // 1、以二进制数组方式获取BLOB数据
                byte[] attach = lobHandler.getBlobAsBytes(rs, 2);
                Post post = new Post();
                post.setPostId(postId);
                post.setPostAttach(attach);
                return post;
            }
        });
    }

    /**
     * 以流数据方式读取LOB数据
     *
     * @param postId int
     * @param os     OutputStream
     */
    public void getAttach(int postId, OutputStream os) {
        String sql = "SELECT post_attach from t_post WHERE post_id=?";
        jdbcTemplate.query(sql, new Object[]{postId}, new int[]{Types.INTEGER}, new AbstractLobStreamingResultSetExtractor<Post>() {
            @Override
            protected void streamData(ResultSet rs) throws SQLException, IOException, DataAccessException {
                InputStream is = lobHandler.getBlobAsBinaryStream(rs, 1);
                if (is != null) {
                    FileCopyUtils.copy(is, os);
                }
            }

            @Override
            protected void handleNoRowFound() throws DataAccessException {
                System.out.println("PostDao.handleNoRowFound");
            }
        });
    }


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setLobHandler(LobHandler lobHandler) {
        this.lobHandler = lobHandler;
    }

    @Autowired
    public void setDataFieldMaxValueIncrementer(DataFieldMaxValueIncrementer dataFieldMaxValueIncrementer) {
        this.dataFieldMaxValueIncrementer = dataFieldMaxValueIncrementer;
    }
}
