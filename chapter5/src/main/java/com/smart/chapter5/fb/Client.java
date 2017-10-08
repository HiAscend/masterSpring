package com.smart.chapter5.fb;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Client
 * Created by zziaa on 2017/10/03.
 */
public class Client {
    private static BeanFactory beanFactory;

    @BeforeClass
    public void setUpClass() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("com/smart/chapter5/fb/beans.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        reader.loadBeanDefinitions(resource);
        beanFactory = defaultListableBeanFactory;
    }

    @Test
    public void testCarFactoryBean() {
        Car car = beanFactory.getBean("car", Car.class);
        System.out.println(car.toString());
    }
}
