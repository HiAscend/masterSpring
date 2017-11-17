package com.smart.chapter12.mixdao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Client
 *
 * @author ascend
 * @date 2017/11/17 14:10.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter12/mixdao/applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        UserService userService = context.getBean("userService", UserService.class);

        jdbcTemplate.update("insert into t_user(user_name, password, score, last_logon_time) values('tom', '123456', 10, "+System.currentTimeMillis()+")");

        System.out.println("before userService.logon()...");
        userService.logon("tom");
        System.out.println("after userService.logon()...");

        jdbcTemplate.update("delete from t_user where user_name='tom'");
    }

}
