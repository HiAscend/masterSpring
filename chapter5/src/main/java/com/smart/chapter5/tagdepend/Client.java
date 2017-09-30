package com.smart.chapter5.tagdepend;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Client
 * Created by zziaa on 2017/09/29.
 */
public class Client {
    private static BeanFactory beanFactory;

    @BeforeClass
    public void setUpClass() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("com/smart/chapter5/tagdepend/beans.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        reader.loadBeanDefinitions(resource);
        beanFactory = defaultListableBeanFactory;
    }

    @Test
    public void test() throws IOException, InterruptedException {
        CacheManager cacheManager = beanFactory.getBean("cacheManager", CacheManager.class);
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void testQuote() {
        Boss boss = beanFactory.getBean("boss4", Boss.class);
        System.out.println(boss.toString());
    }
}
