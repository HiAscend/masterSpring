package com.smart.chapter5.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * ServiceConfig
 * Created by zziaa on 2017/10/09.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
//@Import(DaoConfig.class)
public class ServiceConfig {
    // 1、像普通Bean一样注入DaoConfig
    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        // 2、像普通Bean一样调用Bean相关方法
        logonService.setUserDao(daoConfig.userDao());
        logonService.setLogDao(daoConfig.logDao());
        return logonService;
    }
}
