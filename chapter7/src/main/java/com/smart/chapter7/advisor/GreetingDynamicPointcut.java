package com.smart.chapter7.advisor;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.MethodMatcher;

/**
 * GreetingDynamicPointcut
 *
 * @author ascend
 * @date 2017/11/2 16:57.
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    /**
     * Check whether there a runtime (dynamic) match for this method,
     * which must have matched statically.
     * <p>This method is invoked only if the 2-arg matches method returns
     * {@code true} for the given method and target class, and if the
     * {@link #isRuntime()} method returns {@code true}. Invoked
     * immediately before potential running of the advice, after any
     * advice earlier in the advice chain has run.
     *
     * @param method      the candidate method
     * @param targetClass the target class (may be {@code null}, in which case
     *                    the candidate class must be taken to be the method's declaring class)
     * @param args        arguments to the method
     * @return whether there's a runtime match
     * @see MethodMatcher#matches(Method, Class)
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {

        return false;
    }
}
