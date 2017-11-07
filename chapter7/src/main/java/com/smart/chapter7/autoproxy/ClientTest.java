package com.smart.chapter7.autoproxy;

import com.smart.chapter7.advisor.Seller;
import com.smart.chapter7.advisor.Waiter;
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
    private static final String CONFIG_PATH = "/com/smart/chapter7/autoproxy/beans.xml";

    @Test
    public void testBeanNameAutoProxyCreator() {
        ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
        Waiter waiter = context.getBean("waiter", Waiter.class);
        Seller seller = context.getBean("seller", Seller.class);
        waiter.greetTo("John");
        seller.greetTo("Tom");
    }
}
