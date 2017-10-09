package com.smart.chapter5.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1、将一个POJO标注为定义Bean的配置类
 * AppConf
 * Created by zziaa on 2017/10/09.
 */
@Configuration
public class AppConf {
    // 2、以下两个方法定义了两个Bean，并提供了Bean的实例化逻辑
    @Bean(name = "userDao")
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

    // 3、定义了LogonService的Bean
    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        // 4、将2和3处定义的Bean注入logonService Bean中
        logonService.setUserDao(userDao());
        logonService.setLogDao(logDao());
        return logonService;
    }
}
