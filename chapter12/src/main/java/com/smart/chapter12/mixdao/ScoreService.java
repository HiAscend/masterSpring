package com.smart.chapter12.mixdao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * ScoreService
 *
 * @author ascend
 * @date 2017/11/17 11:44.
 */
@Service
public class ScoreService extends BaseService {
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd) {
        String sql = "update t_user set score=? where user_name=?";
        jdbcTemplate.update(sql, toAdd, userName);
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();

        // 1、查看此处数据库激活的连接数量
        System.out.println("[scoreService.addScore]激活连接数量：" + basicDataSource.getNumActive());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
