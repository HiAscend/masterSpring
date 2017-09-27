package com.smart.chapter4.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * MyBeanFactoryPostProcessor
 * Created by zziaa on 2017/09/27.
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    // 对car 的brand属性配置信息进行“偷梁换柱”的加工操作
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition car = beanFactory.getBeanDefinition("car");
        car.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("MyBeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
