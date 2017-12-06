package com.smart.chapter15.cache.initcache;

import com.smart.chapter15.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * UserMain
 *
 * @author ascend
 * @date 2017/12/06 20:53
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = context.getBean("initUserService", UserService.class);
        User user1 = userService.getUser(1);
        System.out.println("user1 = " + user1);
        User user2 = userService.getUser(2);
        System.out.println("user2 = " + user2);
    }
}
