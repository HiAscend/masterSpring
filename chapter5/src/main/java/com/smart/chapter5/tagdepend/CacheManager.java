package com.smart.chapter5.tagdepend;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CacheManager {
    public CacheManager() {
        Timer timer = new Timer();
        TimerTask cacheTask = new CacheTask();
        timer.schedule(cacheTask, 0, SystemSettings.REFRESH_CYCLE * 1000);
    }


}
