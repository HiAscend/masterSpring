package com.smart.chapter8.aspectj.example;

import com.smart.chapter8.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * ClientTest
 *
 * @author ascend
 * @date 2017/11/9 11:40.
 */
public class ClientTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/example/beans.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.greetTo("katherine");
        waiter.serveTo("katherine");
    }
}
