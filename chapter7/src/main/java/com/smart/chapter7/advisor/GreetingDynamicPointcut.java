package com.smart.chapter7.advisor;

import org.springframework.aop.ClassFilter;
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
     * 对类进行静态切点检查
     * @return ClassFilter
     */
    @Override
    public ClassFilter getClassFilter() {
        return clazz -> {
            System.out.println("调用getClassFilter对" + clazz.getName() + "做静态检查.");
            return Waiter.class.isAssignableFrom(clazz);
        };
    }

    /**
     * 对方法进行静态切点检查
     * Can override to add preconditions for dynamic matching. This implementation
     * always returns true.
     *
     * @param method Method
     * @param targetClass Class
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches(method,clazz)" + targetClass.getName() + "." + method.getName() + "做静态检查");
        return "greetTo".equals(method.getName());
    }

    /**
     * 对方法进行动态切点检查
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
        System.out.println("调用matches(method,clazz)" + targetClass.getName() + "." + method.getName() + "做动态检查");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
}
