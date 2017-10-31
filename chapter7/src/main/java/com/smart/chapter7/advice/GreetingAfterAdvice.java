package com.smart.chapter7.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * GreetingAfterAdvice
 *
 * @author ascend
 * @date 2017/10/31 16:42
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    /**
     * Callback after a given method successfully returned.
     *
     * @param returnValue the value returned by the method, if any
     * @param method      method being invoked
     * @param args        arguments to the method
     * @param target      target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("please enjoy yourself!");
    }
}
