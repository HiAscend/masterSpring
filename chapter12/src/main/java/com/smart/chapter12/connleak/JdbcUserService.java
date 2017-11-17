package com.smart.chapter12.connleak;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * JdbcUserService
 *
 * @author ascend
 * @date 2017/11/17 16:13.
 */
@Service
public class JdbcUserService {
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void logon(String userName) {
        Connection connection = null;
        try {
            // 1、直接从数据源获取连接，后续程序没有显式释放该连接
             connection = jdbcTemplate.getDataSource().getConnection();
//            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            String sql = "UPDATE  t_user set last_logon_time=? where user_name=?";
            jdbcTemplate.update(sql, System.currentTimeMillis(), userName);
            // 2、模拟程序代码执行时间
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DataSourceUtils.releaseConnection(connection, jdbcTemplate.getDataSource());
        }
    }

    /**
     * 以异步线程的方式执行JdbcUserService#logon()方法，以模拟多线程环境
     */
    public static void asynchrLogon(JdbcUserService userService, String userName) {
        UserServiceRunner runner = new UserServiceRunner(userService, userName);
        runner.start();
    }

    /**
     * 让主执行线程睡眠一段指定时间
     *
     * @param time long
     */
    public static void sleep(long time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void reportConn(BasicDataSource basicDataSource) {
        System.out.println("连接数：[active:idle]-[" + basicDataSource.getNumActive() + ":" + basicDataSource.getNumIdle() + "]");
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class UserServiceRunner extends Thread {
        private JdbcUserService userService;
        private String userName;

        public UserServiceRunner(JdbcUserService userService, String userName) {
            this.userService = userService;
            this.userName = userName;
        }

        @Override
        public void run() {
            userService.logon(userName);
        }
    }

}
