package com.smart.chapter8.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * AspectjLtwTest
 *
 * @author ascend
 * @date 2017/11/14 11:32.
 */
public class AspectjLtwTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/ltw/beans.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.greetTo("katherine");
        waiter.serveTo("katherine");
    }
}
