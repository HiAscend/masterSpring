package com.smart.chapter12.connleak;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Client
 *
 * @author ascend
 * @date 2017/11/17 16:28.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter12/connleak/applicationContext.xml");
        JdbcUserService userService = context.getBean("jdbcUserService", JdbcUserService.class);
//        BasicDataSource basicDataSource = context.getBean("dataSource", BasicDataSource.class);
        BasicDataSource basicDataSource = context.getBean("originDataSource", BasicDataSource.class);

        // 4、汇报数据源初始连接占用情况
        JdbcUserService.reportConn(basicDataSource);

        // 启动一个异步线程A
        JdbcUserService.asynchrLogon(userService, "tom");
        JdbcUserService.sleep(500);

        // 5、此时线程A正在执行JdbcUserService#logon()方法
        JdbcUserService.reportConn(basicDataSource);

        JdbcUserService.sleep(2000);

        // 6、此时线程A所执行的JdbcUserService#logon()方法已经执行完毕
        JdbcUserService.reportConn(basicDataSource);

        // 启动一个异步线程B
        JdbcUserService.asynchrLogon(userService, "john");
        JdbcUserService.sleep(500);

        // 7、此时线程B正在执行JdbcUserService#logon()方法
        JdbcUserService.reportConn(basicDataSource);
        JdbcUserService.sleep(2000);

        // 8、此时线程A和B都已经完成JdbcUserService#logon()方法的执行
        JdbcUserService.reportConn(basicDataSource);
    }

}
