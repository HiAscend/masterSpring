package com.smart.chapter15.cache.cacheput;

import com.smart.chapter15.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserMain
 *
 * @author ascend
 * @date 2017/12/03 18:47
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = context.getBean("cachePutUserService", UserService.class);

        User user = userService.getUser(1);
        System.out.println("user = " + user);
        User user2 = userService.getUser(1);
        System.out.println("user2 = " + user2);
    }
}
