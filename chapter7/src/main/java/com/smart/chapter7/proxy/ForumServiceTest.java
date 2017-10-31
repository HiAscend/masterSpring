package com.smart.chapter7.proxy;

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
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
