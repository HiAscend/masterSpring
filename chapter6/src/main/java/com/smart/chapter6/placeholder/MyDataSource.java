package com.smart.chapter6.placeholder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * MyDataSource
 *
 * @author ascend
 * @date 2017/10/24 15:21
 */
@Component
public class MyDataSource {
    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${useName}")
    private String userName;
    @Value("${password}")
    private String password;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
