package com.smart.chapter5.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Client
 * Created by zziaa on 2017/10/09.
 */
public class Client {
    @Test
    public void test() {
        // 1、使用@Configuration提供的Bean定义信息启动容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf.class);
        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHelllo();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 1、注册多个@Configuration配置类
        ctx.register(DaoConfig.class);
        ctx.register(ServiceConfig.class);
        // 2、刷新容器以应用这些注册的配置类
        ctx.refresh();
        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHelllo();
    }

    @Test
    public void test3() {
        // 1、使用@Configuration提供的Bean定义信息启动容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LogonAppConfig.class);
        LogonService logonService = ctx.getBean(LogonService.class);
        logonService.printHelllo();
    }
}
