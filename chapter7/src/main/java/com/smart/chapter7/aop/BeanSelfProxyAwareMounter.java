package com.smart.chapter7.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * BeanSelfProxyAwareMounter
 *
 * @author ascend
 * @date 2017/11/8 11:53.
 */
@Component
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware{
    private static final Logger LOG = LoggerFactory.getLogger(BeanSelfProxyAwareMounter.class);
    private ApplicationContext applicationContext;
    /**
     * 在系统就绪后调用的方法
     */
    @Override
    public void onReady() {
        Map<String, BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        if (proxyAwareMap != null) {
            for (BeanSelfProxyAware beanSelfProxyAware : proxyAwareMap.values()) {
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                LOG.debug("注册自身被代理的实例");
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
