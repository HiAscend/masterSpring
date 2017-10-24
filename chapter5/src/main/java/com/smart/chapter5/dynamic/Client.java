package com.smart.chapter5.dynamic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Client
 *
 * @author zziaa
 * @date 2017/10/12
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/chapter5/dynamic/custom.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.printHello();
        ctx.close();
    }
}
