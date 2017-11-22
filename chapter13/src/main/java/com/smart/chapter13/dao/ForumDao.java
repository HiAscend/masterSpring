package com.smart.chapter13.dao;

import com.smart.chapter13.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;

/**
 * ForumDao
 *
 * @author ascend
 * @date 2017/11/22 15:49.
 */
@Repository
public class ForumDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void initDb() {
        String sql = "create table t_user(user_id int primary key,user_name varchar(60))";
        jdbcTemplate.execute(sql);
    }

    /**
     * 更新一条数据
     *
     * @param forum
     */
    public void addForum(final Forum forum) {
        final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        Object[] params = new Object[]{forum.getForumName(),
            forum.getForumDesc()};
        // 方式1
        // jdbcTemplate.update(sql, params);

        // 方式2
        // jdbcTemplate.update(sql, params,new
        // int[]{Types.VARCHAR,Types.VARCHAR});

        // 方式3
        /*
         * jdbcTemplate.update(sql, new PreparedStatementSetter() { public void
		 * setValues(PreparedStatement ps) throws SQLException { ps.setString(1,
		 * forum.getForumName()); ps.setString(2, forum.getForumDesc()); } });
		 */

        // 方式4
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn)
                throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, forum.getForumName());
                ps.setString(2, forum.getForumDesc());
                return ps;
            }
        }, keyHolder);
        forum.setForumId(keyHolder.getKey().intValue());
    }

    public void addForumByNamedParams(final Forum forum) {
        final String sql = "INSERT INTO t_forum(forum_name, forum_desc) VALUES(:forumName,:forumDesc)";
        SqlParameterSource sps = new BeanPropertySqlParameterSource(forum);
        namedParameterJdbcTemplate.update(sql, sps);
    }

    /**
     * 批量更新数据
     *
     * @param forumList List
     */
    public void addForums(List<Forum> forumList) {
        final String sql = "insert into t_forum(forum_name, forum_desc) values(?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Forum forum = forumList.get(i);
                ps.setString(1, forum.getForumName());
                ps.setString(2, forum.getForumDesc());
            }

            @Override
            public int getBatchSize() {
                return forumList.size();
            }
        });
    }

    /**
     * 根据forumId获取Forum对象
     *
     * @param forumId int
     * @return Forum
     */
    public Forum getForum(int forumId) {
        String sql = "select forum_name, forum_desc from t_forum where forum_id=?";
        Forum forum = new Forum();
        jdbcTemplate.query(sql, new Object[]{forumId}, rs -> {
            forum.setForumId(forumId);
            forum.setForumName(rs.getString("forum_name"));
            forum.setForumDesc(rs.getString("forum_desc"));
        });
        return forum;
    }

    /**
     * 获取List
     * @param fromId int
     * @param toId int
     * @return List
     */
    public List<Forum> getForumList(int fromId, int toId) {
        String sql = "select forum_id, forum_name, forum_desc from t_forum where forum_id between ? and ?";
        // 使用RowCallbackHandler
        /*List<Forum> retList = new ArrayList<>();
        jdbcTemplate.query(sql, new Object[]{
            fromId,
            toId
        }, rs -> {
            Forum forum = new Forum();
            forum.setForumId(rs.getInt("forum_id"));
            forum.setForumName(rs.getString("forum_name"));
            forum.setForumDesc(rs.getString("forum_desc"));
            retList.add(forum);
        });
        return retList;*/

        // 使用RowMapper
        return jdbcTemplate.query(sql, new Object[]{
            fromId,
            toId
        }, new int[]{Types.VARCHAR, Types.VARCHAR}, (rs, rowNum) -> {
            Forum forum = new Forum();
            forum.setForumId(rs.getInt("forum_id"));
            forum.setForumName(rs.getString("forum_name"));
            forum.setForumDesc(rs.getString("forum_desc"));
            return forum;
        });
//        jdbcTemplate.queryForObject();
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

}
