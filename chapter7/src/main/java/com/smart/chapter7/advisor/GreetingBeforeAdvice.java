package com.smart.chapter7.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * GreetingBeforeAdvice
 *
 * @author ascend
 * @date 2017/11/2 14:47.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
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
        // 输出切点
        System.out.println(target.getClass().getName() + "." + method.getName());
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
