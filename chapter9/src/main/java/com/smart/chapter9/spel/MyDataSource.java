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
    @Value(value = "${driverClassName}")
    private String driverClassName;
    @Value(value = "${url}")
    private String url;
    @Value(value = "${userName}")
    private String userName;
    @Value(value = "${password}")
    private String password;
}
