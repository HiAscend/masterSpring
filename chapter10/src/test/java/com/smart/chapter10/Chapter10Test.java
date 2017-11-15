package com.smart.chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Chapter10Test
 *
 * @author ascend
 * @date 2017/11/15 11:02.
 */
public class Chapter10Test {
    @Test
    public void test() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        if (connection != null) {
            System.out.println("connection = " + connection);
            DatabaseMetaData metaData = connection.getMetaData();
            boolean b = metaData.supportsSavepoints();
            System.out.println("b = " + b);
            connection.close();
        }
    }

    @Test
    public void testDriverManagerDataSource() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
        DriverManagerDataSource dataSource = context.getBean("driverManagerDataSource", DriverManagerDataSource.class);
        Connection connection = dataSource.getConnection();
        if (connection != null) {
            System.out.println("connection = " + connection);
            DatabaseMetaData metaData = connection.getMetaData();
            boolean b = metaData.supportsSavepoints();
            System.out.println("b = " + b);
            connection.close();
        }
    }
}
