package com.smart.chapter7.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * BeforeAdviceTest
 *
 * @author ascend
 * @date 2017/10/31 11:52
 */
public class BeforeAdviceTest {
    @Test
    public void testBefore() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // 1、Spring提供的代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 若指定对接口进行代理，则会使用jdk进行代理
//        proxyFactory.setInterfaces(target.getClass().getInterfaces());
        // 若启用优化，则还会使用cglib代理
//        proxyFactory.setOptimize(true);

        // 2、设置代理目标
        proxyFactory.setTarget(target);
        // 3、为代理目标添加增强
        proxyFactory.addAdvice(advice);
        // 4、生成代理实例
        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("katherine");
        proxy.serveTo("Elena");
    }

    @Test
    public void testBefore2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/advice/beans.xml");
        Waiter waiter = context.getBean("waiter", Waiter.class);
        waiter.greetTo("katherine");
    }

    @Test
    public void testBefore3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/advice/beans.xml");
        Waiter waiter = context.getBean("waiter2", Waiter.class);
        waiter.greetTo("katherine");
    }

}
