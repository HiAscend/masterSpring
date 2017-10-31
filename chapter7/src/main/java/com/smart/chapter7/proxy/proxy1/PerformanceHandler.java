package com.smart.chapter7.proxy.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * PerformanceHandler
 *
 * @author ascend
 * @date 2017/10/31 10:12
 */
public class PerformanceHandler implements InvocationHandler {
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
