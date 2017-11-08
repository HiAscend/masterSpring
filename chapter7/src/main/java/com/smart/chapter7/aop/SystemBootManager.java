package com.smart.chapter7.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

/**
 * SystemBootManager
 *
 * @author ascend
 * @date 2017/11/8 11:40.
 */
@Component
public class SystemBootManager implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(SystemBootManager.class);

    private List<SystemBootAddon> systemBootAddonList = Collections.emptyList();
    private boolean hasRunOnce = false;

    /**
     * 注入所有SystemBootAddon插件
     * @param systemBootAddonList  List
     */
    @Autowired(required = false)
    public void setSystemBootAddonList(List<SystemBootAddon> systemBootAddonList) {
        Assert.notEmpty(systemBootAddonList);
        OrderComparator.sort(systemBootAddonList);
        this.systemBootAddonList = systemBootAddonList;
    }

    /**
     * 触发所有插件
     * @param contextRefreshedEvent ContextRefreshEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!hasRunOnce) {
            for (SystemBootAddon systemBootAddon : systemBootAddonList) {
                systemBootAddon.onReady();
                LOG.debug("执行插件：{}", systemBootAddon.getClass().getCanonicalName());
            }
            hasRunOnce = true;
        } else {
            LOG.debug("已执行过容器启动插件集,本次忽略之.");
        }
    }
}
