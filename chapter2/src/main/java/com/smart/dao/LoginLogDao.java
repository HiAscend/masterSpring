package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * LoginLog
 * Created by ascend on 2017/8/21 11:17.
 */
@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_LOGIN_LOG_SQL = " insert into t_login_log(user_id, ip, login_datetime) " +
            " values(?, ?, ?) ";

    public void insertLoginLog(LoginLog loginLog) {
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,
                loginLog.getUserId(),
                loginLog.getIp(),
                loginLog.getLoginDate());





        
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
