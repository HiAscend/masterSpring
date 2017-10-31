package com.smart.chapter7.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * GreetingBeforeAdvice
 *
 * @author ascend
 * @date 2017/10/31 11:39
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
