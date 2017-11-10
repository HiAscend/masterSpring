package com.smart.chapter8.schema;

import com.smart.chapter8.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * SchemaAspectTest
 *
 * @author ascend
 * @date 2017/11/10 10:37.
 */
public class SchemaAspectTest {
    @Test
    public void testPreGreeting() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/schema/beans.xml");
        Waiter naiveWaiter = context.getBean("naiveWaiter", Waiter.class);
        Waiter naughtyWaiter = context.getBean("naughtyWaiter", Waiter.class);
        naiveWaiter.greetTo("John");
        naughtyWaiter.greetTo("Tom");
    }
}
