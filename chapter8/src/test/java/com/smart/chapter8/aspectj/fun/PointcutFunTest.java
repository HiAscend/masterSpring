package com.smart.chapter8.aspectj.fun;

import com.smart.chapter8.Seller;
import com.smart.chapter8.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * PointcutFunTest
 *
 * @author ascend
 * @date 2017/11/9 14:41.
 */
public class PointcutFunTest {
    @Test
    public void pointcut() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/fun/beans.xml");
        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
        Waiter naughtyWaiter = context.getBean("naughtyWaiter", Waiter.class);
        naiveWaiter.greetTo("katherine");
        naughtyWaiter.greetTo("Elena");
    }

    @Test
    public void testThis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/fun/beans.xml");
        Waiter naiveWaiter = (Waiter) context.getBean("naiveWaiter");
       naiveWaiter.greetTo("John");
       naiveWaiter.serveTo("John");
        ((Seller) naiveWaiter).sell("Beer", "John");
    }
}
