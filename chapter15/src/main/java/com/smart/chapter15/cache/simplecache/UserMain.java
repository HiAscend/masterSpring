package com.smart.chapter15.cache.simplecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserMain
 *
 * @author ascend
 * @date 2017/11/30 22:01
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);

        // 第一次查询
        System.out.println("first query...");
        userService.getUserById("somebody");

        // 第二次查询，应该不查询数据库，直接返回缓存中的指
        System.out.println("second query...");
        userService.getUserById("somebody");
//        userService.getUserById("somebodyelse");
    }
}
