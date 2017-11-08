package com.smart.chapter7.aop;

import org.springframework.core.Ordered;

/**
 * SystemBootAddon
 *
 * @author ascend
 * @date 2017/11/8 11:38.
 */
public interface SystemBootAddon extends Ordered {
    /**
     * 在系统就绪后调用的方法
     */
    void onReady();
}
