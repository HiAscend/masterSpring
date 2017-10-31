package com.smart.chapter7.proxy.proxy2;

import org.testng.annotations.Test;

/**
 * ForumServiceTest
 *
 * @author ascend
 * @date 2017/10/31 9:49
 */
public class ForumServiceTest {
    @Test
    public void test() {
        CglibProxy proxy = new CglibProxy();
        ForumService forumService = (ForumService) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
