package com.smart.chapter7.advisor;

import com.smart.chapter7.aop.BeanSelfProxyAware;

/**
 * Waiter
 *
 * @author ascend
 * @date 2017/11/2 14:29.
 */
public class Waiter2 implements BeanSelfProxyAware{
    private Waiter2 waiter;

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serve to " + name + "...");
        this.waiter.greetTo(name);
    }

    /**
     * 设置自身代理
     *
     * @param object Object
     */
    @Override
    public void setSelfProxy(Object object) {
        this.waiter = (Waiter2) object;
    }
}
