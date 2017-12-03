package com.smart.chapter15.cache.cachegroup;

import com.smart.chapter15.cache.domain.User;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Main
 *
 * @author ascend
 * @date 2017/12/03 19:28
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = context.getBean("cacheGroupUserService", UserService.class);

        Member member = new Member("1", "w1");
        Visitor visitor = new Visitor("2", "w2");

        User user1 = userService.getUser(member);
        System.out.println("user1 = " + user1);
        User user2 = userService.getUser(visitor);
        System.out.println("user2 = " + user2);

        CacheManager cacheManager = context.getBean("cacheManager", CacheManager.class);
        Cache members = cacheManager.getCache("members");
        System.out.println("members cache storage:" + ((ConcurrentHashMap) members.getNativeCache()).values());
        Cache visitors = cacheManager.getCache("visitors");
        System.out.println("visitors cache storage:" + ((ConcurrentHashMap) visitors.getNativeCache()).values());
    }
}
