package com.smart.chapter4.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * BeanLifeCycle
 * Created by ascend on 2017/9/27 12:49.
 */
public class BeanLifeCycle {
    private static void lifeCycleInBeanFactory() {
        // 装载配置文件并启动
        Resource resource = new ClassPathResource("com/smart/beanfactory/beans1.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);

        // 向容器中注册MyBeanPostProcessor后处理器

    }
}
