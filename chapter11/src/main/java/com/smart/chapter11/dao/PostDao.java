package com.smart.chapter11.dao;

import com.smart.chapter11.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * PostDao
 *
 * @author ascend
 * @date 2017/11/15 18:06.
 */
@Repository
public class PostDao {
    private JdbcTemplate jdbcTemplate;

    public void addPost(final Post post) {
        String sql = " INSERT INTO t_post(topic_id,post_text) VALUES(?,?)";
        Object[] params = new Object[]{post.getTopicId(), post.getPostText()};
        jdbcTemplate.update(sql, params);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
