package com.smart.chapter7.advisor;

import com.smart.chapter7.introduce.ForumService;
import com.smart.chapter7.introduce.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * ClientTest
 *
 * @author ascend
 * @date 2017/11/2 15:05.
 */
public class ClientTest {

    private final String configLocation = "/com/smart/chapter7/advisor/beans.xml";

    @Test
    public void testStaticMethodMatcherPointcutAdvisor() {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        Waiter waiter = context.getBean("waiter", Waiter.class);
        Seller seller = context.getBean("seller", Seller.class);

        waiter.greetTo("katherine");
        waiter.serveTo("katherine");
        seller.greetTo("katherine");

    }

    @Test
    public void testRegexpMethodPointcutAdvisor() {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        Waiter waiter = context.getBean("waiter2", Waiter.class);

        waiter.greetTo("damon");
        waiter.serveTo("damon");

        Seller seller = context.getBean("seller2", Seller.class);
        seller.greetTo("stefan");
    }

    @Test
    public void testDynamicAdvisor() {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        Waiter waiter = context.getBean("waiter3", Waiter.class);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }

    @Test
    public void testControlFlowPointcut() {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        Waiter waiter = context.getBean("waiter4", Waiter.class);
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiterDelegate.service("Peter");
    }

    @Test
    public void testComposablePointcut() {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        Waiter waiter = context.getBean("waiter5", Waiter.class);
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiterDelegate.service("Peter");
    }

    @Test
    public void testIntroducePointcut() {
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
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
