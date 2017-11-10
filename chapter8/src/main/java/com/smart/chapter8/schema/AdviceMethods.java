package com.smart.chapter8.schema;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AdviceMethods
 * 切面增强
 *
 * @author ascend
 * @date 2017/11/10 10:12.
 */
public class AdviceMethods {
    public void preGreeting() {
        System.out.println("--how are you--");
//        System.out.println(name);
    }

    /**
     * 后置增强对应方法
     *
     * @param retVal int
     */
    public void afterReturning(int retVal) {
        System.out.println("AdviceMethods.afterReturning");
        System.out.println("retVal = " + retVal);
        System.out.println("AdviceMethods.afterReturning");
    }

    /**
     * 环绕增强对应方法
     *
     * @param pjp ProceedingJoinPoint
     */
    public void aroundMethod(ProceedingJoinPoint pjp) {
        System.out.println("AdviceMethods.aroundMethod");
        System.out.println("args[0]:" + pjp.getArgs()[0]);
        System.out.println("AdviceMethods.aroundMethod");
    }

    /**
     * 抛出异常增强
     *
     * @param iae IllegalArgumentException
     */
    public void afterThrowingMethod(IllegalArgumentException iae) {
        System.out.println("AdviceMethods.afterThrowingMethod");
        System.out.println("exception message:" + iae.getMessage());
        System.out.println("AdviceMethods.afterThrowingMethod");
    }

    /**
     * final增强
     */
    public void afterMethod() {
        System.out.println("AdviceMethods.afterMethod");
    }


    /**
     * 绑定连接点参数
     *
     * @param num  int
     * @param name String
     */
    public void bindParams(int num, String name) {
        System.out.println("AdviceMethods.bindParams");
        System.out.println("name = " + name);
        System.out.println("num = " + num);
        System.out.println("AdviceMethods.bindParams");
    }

}
