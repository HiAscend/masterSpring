package com.smart.chapter8.aspectj.advanced;

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
}
