package com.smart.chapter7.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * IntroduceTest
 *
 * @author ascend
 * @date 2017/11/2 10:46.
 */
public class IntroduceTest {
    @Test
    public void testIntroduce() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter7/introduce/beans.xml");
        ForumService forumService = context.getBean("forumService", ForumService.class);
        // 默认情况下未开启性能监视
        forumService.removeForum(10);
        forumService.removeTopic(1022);

        // 开启性能监视功能
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }
}
