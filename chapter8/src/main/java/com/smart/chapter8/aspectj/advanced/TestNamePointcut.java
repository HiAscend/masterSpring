package com.smart.chapter8.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

/**
 * TestNamePointcut
 *
 * @author ascend
 * @date 2017/11/9 17:10.
 */
public class TestNamePointcut {
    @Pointcut(value = "within(com.smart.chapter8.*)")
    private void inPackage() {
    }

    @Pointcut(value = "execution(* greetTo(..))")
    protected void greetTo() {
    }

    @Pointcut(value = "inPackage() && greetTo()")
    public void inPkgGreetTo() {
    }
}
