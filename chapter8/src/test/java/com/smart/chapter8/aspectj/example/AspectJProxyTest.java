package com.smart.chapter8.aspectj.example;

import com.smart.chapter8.NaiveWaiter;
import com.smart.chapter8.Waiter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.Test;

/**
 * AspectJProxyTest
 *
 * @author ascend
 * @date 2017/11/9 11:19.
 */
public class AspectJProxyTest {
    @Test
    public void test() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        // 1、设置目标对象
        factory.setTarget(target);
        // 2、添加切面类
        factory.addAspect(PreGreetingAspect.class);
        // 3、生成织入切面的代理对象
        Waiter proxy = factory.getProxy();
        proxy.greetTo("katherine");
        proxy.serveTo("katherine");
    }

}
