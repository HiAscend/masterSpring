package com.smart.chapter8.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

/**
 * TestAspect
 *
 * @author ascend
 * @date 2017/11/9 14:30.
 */
@Aspect
public class TestAspect implements Ordered{

    /*@AfterReturning(value = "@annotation(com.smart.chapter8.anno.NeedTest)")
    public void needTestFun() {
        System.out.println("TestAspect.needTestFun");
    }*/

    /**
     * 后置增强，织入任何运行时期对象为Seller类型的Bean中
     */
    @AfterReturning(value = "this(com.smart.chapter8.Seller)")
    public void thisTest() {
        System.out.println("TestAspect.thisTest");
    }


    @Override
    public int getOrder() {
        return 1;
    }
}
