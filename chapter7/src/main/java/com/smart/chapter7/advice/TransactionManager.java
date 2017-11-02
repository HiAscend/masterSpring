package com.smart.chapter7.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * TransactionManager
 *
 * @author ascend
 * @date 2017/11/2 9:23.
 */
public class TransactionManager implements ThrowsAdvice {

    /**
     * 定义逻辑增强
     * @param method Method
     * @param args Object[]
     * @param target Object
     * @param ex Throwable
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("------------");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常：" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }
}
