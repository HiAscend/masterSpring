package com.smart.chapter7.autoproxy;

import com.smart.chapter7.advisor.Seller;
import com.smart.chapter7.advisor.Waiter;
import com.smart.chapter7.advisor.Waiter2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * ClientTest
 *
 * @author ascend
 * @date 2017/11/7 17:53.
 */
public class ClientTest {
    private static final Logger LOG = LoggerFactory.getLogger(ClientTest.class);
    private static final String CONFIG_PATH = "/com/smart/chapter7/autoproxy/beans.xml";

    @Test
    public void testBeanNameAutoProxyCreator() {
        ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
        Waiter waiter = context.getBean("waiter", Waiter.class);
        Seller seller = context.getBean("seller", Seller.class);
        waiter.greetTo("John");
        seller.greetTo("Tom");
    }

    @Test
    public void testDefaultAdvisorAutoProxyCreator() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter7/autoproxy/beans2.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        Seller seller = context.getBean("seller", Seller.class);
        waiter.serveTo("John");
        waiter.greetTo("John");
        seller.greetTo("Tom");
    }

    @Test
    public void testAutoProxy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter7/autoproxy/beans-aware.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.serveTo("John");

        waiter.greetTo("John");
    }

    @Test
    public void testAutoProxy2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter7/autoproxy/beans-aware.xml");
        Waiter2 waiter = context.getBean("waiter", Waiter2.class);
        waiter.serveTo("John");
//        waiter.greetTo("John");
    }
}
