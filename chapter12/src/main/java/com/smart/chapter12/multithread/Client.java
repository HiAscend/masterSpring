package com.smart.chapter12.multithread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Client
 *
 * @author ascend
 * @date 2017/11/17 10:36.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter12/multithread/applicationContext.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        UserService userService = context.getBean("userService", UserService.class);
        jdbcTemplate.update("insert into t_user(user_name, password, score, last_logon_time) values('tom', '123456', 10, "+System.currentTimeMillis()+")");
        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon method...");
        userService.logon("tom");
        System.out.println("after userService.logon method...");

        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}
