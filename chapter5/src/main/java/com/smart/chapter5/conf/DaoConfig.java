package com.smart.chapter5.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * DaoConfig
 * Created by zziaa on 2017/10/09.
 */
@Configuration
public class DaoConfig {
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    @Scope("prototype")
    @Bean
    public LogDao logDao(){
        return new LogDao();
    }
}
