package com.smart.chapter9.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MyDataSource
 *
 * @author ascend
 * @date 2017/11/14 18:05.
 */
@Component
public class MyDataSource {
    @Value(value = "#{jdbcProperties['driverClassName']}")
    private String driverClassName;
    @Value(value = "#{jdbcProperties['url']}")
    private String url;
    @Value(value = "#{jdbcProperties['userName']}")
    private String userName;
    @Value(value = "#{jdbcProperties['password']}")
    private String password;
}
