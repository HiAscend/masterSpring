package com.smart.chapter7.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * GreetingAdvisor
 *
 * @author ascend
 * @date 2017/11/2 14:32.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    /**
     * Perform static checking whether the given method matches. If this
     * returns {@code false} or if the {@link #isRuntime()} method
     * returns {@code false}, no runtime check (i.e. no.
     * {@link #matches(Method, Class, Object[])} call) will be made.
     *
     * @param method      the candidate method
     * @param targetClass the target class (may be {@code null}, in which case
     *                    the candidate class must be taken to be the method's declaring class)
     * @return whether or not this method matches statically
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 1、切点方法匹配规则：方法名为greetTo
        return "greetTo".equals(method.getName());
    }

    /**
     * 通过覆写getClassFilter，让它匹配Waiter类及其子类
     *
     * @return ClassFilter
     */
    @Override
    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }
}
