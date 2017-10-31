package com.smart.chapter7.proxy.proxy1;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

/**
 * ForumServiceTest
 *
 * @author ascend
 * @date 2017/10/31 9:49
 */
public class ForumServiceTest {
    @Test
    public void test() {
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        proxy.removeForum(10);
        proxy.removeTopic(1012);

    }
}
