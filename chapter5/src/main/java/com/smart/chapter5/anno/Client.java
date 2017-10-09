package com.smart.chapter5.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Client
 * Created by zziaa on 2017/10/09.
 */
public class Client {
    public static void main(String[] args) {
        // 启动容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/chapter5/anno/beans.xml");
        // 关闭容器
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
