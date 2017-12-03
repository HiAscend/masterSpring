package com.smart.chapter15.cache.cacheevict;

import com.smart.chapter15.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserMain
 *
 * @author ascend
 * @date 2017/12/03 19:14
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) context.getBean("cacheEvictUserService");

        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(1);
        System.out.println(userFetch2);

        userService.removeUser(1);
        User userFetch3 = userService.getUser(1);
        System.out.println("Fetched user should be null: " + userFetch3);
    }
}
