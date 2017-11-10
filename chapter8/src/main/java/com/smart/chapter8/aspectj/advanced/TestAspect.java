package com.smart.chapter8.aspectj.advanced;

import com.smart.chapter8.Monitorable;
import com.smart.chapter8.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切点复合运算
 * TestAspect
 *
 * @author ascend
 * @date 2017/11/9 16:25.
 */
@Aspect
public class TestAspect {
    //-------------复合运算----------
    // 与运算
   /* @After(value = "within(com.smart.chapter8.*) && execution(* greetTo(..))")
    public void greetToFun() {
        System.out.println("TestAspect.greetToFun");
    }*/

    /**
     * 与非运算
     */
   /* @Before(value = "!target(com.smart.chapter8.NaiveWaiter) && execution(* serveTo(..))")
    public void notServeInNaiveWaiter() {
        System.out.println("TestAspect.notServeInNaiveWaiter");
    }*/

    /**
     * 或运算
     */
   /* @AfterReturning(value = "target(com.smart.chapter8.Waiter) || target(com.smart.chapter8.Seller)")
    public void waiterOrSeller() {
        System.out.println("TestAspect.waiterOrSeller");
    }*/

    //------------引用命名切点----------

    /*@Before(value = "TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetTo() {
        System.out.println("TestAspect.pkgGreetTo");
    }*/

    /*@Before(value = "!target(com.smart.chapter8.NaiveWaiter) && TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetToNotNaiveWaiter() {
        System.out.println("TestAspect.pkgGreetToNotNaiveWaiter");
    }*/

    // ------------访问连接点信息


    /*@Around(value = "execution(* greetTo(..)) && target(com.smart.chapter8.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("TestAspect.joinPointAccess");
        System.out.println("args[0]:" + joinPoint.getArgs()[0]);
        System.out.println("signature:" + joinPoint.getTarget().getClass());
        joinPoint.proceed();
        System.out.println("TestAspect.joinPointAccess");
    }*/

    // ------------绑定连接点参数
    /*@Before(value = "target(com.smart.chapter8.NaiveWaiter) && args(name, num,..)")
    public void bindPointParams(int num, String name) {
        System.out.println("TestAspect.bindPointParams");
        System.out.println("name = " + name);
        System.out.println("num = " + num);
        System.out.println("TestAspect.bindPointParams");
    }*/

    // ------------绑定代理对象
    /*@Before(value = "execution(* greetTo(..)) && this(waiter)")
    public void bindProxyObj(Waiter waiter) {
        System.out.println("TestAspect.bindProxyObj");
        System.out.println(waiter.getClass().getName());
        System.out.println("TestAspect.bindProxyObj");
    }*/
    /*@Before(value = "execution(* greetTo(..)) && target(waiter)")
    public void bindProxyObj(Waiter waiter) {
        System.out.println("TestAspect.bindProxyObj");
        System.out.println(waiter.getClass().getName());
        System.out.println("TestAspect.bindProxyObj");
    }*/

    // ------------绑定类注解对象
    /*@Before(value = "@within(m)")
    public void bindTypeAnnoObject(Monitorable m) {
        System.out.println("TestAspect.bindTypeAnnoObject");
        System.out.println(m.getClass().getName());
        System.out.println("TestAspect.bindTypeAnnoObject");
    }*/

    // ------------绑定返回值
    /*@AfterReturning(value = "target(com.smart.chapter8.SmartSeller)", returning = "retVal")
    public void bingReturnValue(int retVal) {
        System.out.println("TestAspect.bingReturnValue");
        System.out.println("retVal = " + retVal);
        System.out.println("TestAspect.bingReturnValue");
    }*/

    // ------------绑定抛出的异常
    @AfterThrowing(value = "target(com.smart.chapter8.SmartSeller)", throwing = "iae")
    public void bindException(IllegalArgumentException iae) {
        System.out.println("TestAspect.bindException");
        System.out.println("exception:" + iae.getMessage());
        System.out.println("TestAspect.bindException");
    }

}
