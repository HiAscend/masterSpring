package com.smart.chapter15.cache.ehcache;

import com.smart.chapter15.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * UserMain
 *
 * @author ascend
 * @date 2017/12/07 21:48
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext-ehcache.xml");
        UserService userService = context.getBean("ehcacheUserService", UserService.class);
        User user1 = new User("2", "w2", 34);
        User userFetch1 = userService.getUser(user1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(user1);
        System.out.println(userFetch2);
    }
}
