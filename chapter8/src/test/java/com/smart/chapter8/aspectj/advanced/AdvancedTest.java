package com.smart.chapter8.aspectj.advanced;

import com.smart.chapter8.NaiveWaiter;
import com.smart.chapter8.Seller;
import com.smart.chapter8.SmartSeller;
import com.smart.chapter8.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * AdvancedTest
 *
 * @author ascend
 * @date 2017/11/9 18:02.
 */
public class AdvancedTest {
    @Test
    public void testJoinPointAccess() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/advanced/beans.xml");
        Waiter naiveWaiter = context.getBean("naiveWaiter", Waiter.class);
        naiveWaiter.greetTo("katherine");
    }

    @Test
    public void testBindPointParams() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/advanced/beans.xml");
        NaiveWaiter naiveWaiter = (NaiveWaiter) context.getBean("naiveWaiter");
        naiveWaiter.smile("John", 2);
        naiveWaiter.smile2(2, "John");
    }

    @Test
    public void testBindProxyObj() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/advanced/beans.xml");
        Waiter naiveWaiter = context.getBean("naiveWaiter", Waiter.class);
        naiveWaiter.greetTo("katherine");
    }

    @Test
    public void testBindTypeAnnoObject() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/advanced/beans.xml");
        Waiter waiter = context.getBean("naiveWaiter", NaiveWaiter.class);
        waiter.greetTo("katherine");
    }

    @Test
    public void testBindReturnValue() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/advanced/beans.xml");
        Seller seller = context.getBean("seller", SmartSeller.class);
        seller.sell("Beer", "katherine");
    }

    @Test
    public void testBindException() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/aspectj/advanced/beans.xml");
        SmartSeller seller = context.getBean("seller", SmartSeller.class);
        seller.checkBill(1);
//        seller.checkBill(2);

    }
}
