package com.smart.chapter12.nestcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * ScoreService
 *
 * @author ascend
 * @date 2017/11/16 17:12.
 */
@Service
public class ScoreService implements BaseService {
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd) {
        String sql = "update t_user set score=? where user_name=?";
        jdbcTemplate.update(sql, toAdd, userName);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
