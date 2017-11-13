package com.smart.chapter8.schema;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * TestBeforeAdvice
 *
 * @author ascend
 * @date 2017/11/13 17:53.
 */
public class TestBeforeAdvice implements MethodBeforeAdvice {

    /**
     * Callback before a given method is invoked.
     *
     * @param method method being invoked
     * @param args   arguments to the method
     * @param target target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("TestBeforeAdvice.before");
        System.out.println("clientName:" + args[0]);
        System.out.println("TestBeforeAdvice.before");
    }
}
