package com.smart.chapter7.aop;

/**
 * BeanSelfProxyAware
 *
 * @author ascend
 * @date 2017/11/8 11:48.
 */
public interface BeanSelfProxyAware {
    /**
     * 设置自身代理
     * @param object Object
     */
    void setSelfProxy(Object object);
}
