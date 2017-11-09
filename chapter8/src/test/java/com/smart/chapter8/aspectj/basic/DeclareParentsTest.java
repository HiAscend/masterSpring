package com.smart.chapter8.aspectj.basic;

import com.smart.chapter8.Seller;
import com.smart.chapter8.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * DeclareParentsTest
 *
 * @author ascend
 * @date 2017/11/9 14:39.
 */
public class DeclareParentsTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/basic/beans.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.greetTo("katherine");
        Seller seller = (Seller) waiter;
        seller.sell("Beer", "katherine");
    }
}
