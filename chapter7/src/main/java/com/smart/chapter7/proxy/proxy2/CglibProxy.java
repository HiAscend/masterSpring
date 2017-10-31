package com.smart.chapter7.proxy.proxy2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxy
 *
 * @author ascend
 * @date 2017/10/31 10:39
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        // 设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 通过字节码技术动态创建实例
        return enhancer.create();
    }

    /**
     * 拦截父类所有方法的调用
     *
     * @param o           Object
     * @param method      Method
     * @param args        Object[]
     * @param methodProxy MethodProxy
     * @return Object
     * @throws Throwable Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        // 通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(o, args);
        PerformanceMonitor.end();
        return result;
    }
}
