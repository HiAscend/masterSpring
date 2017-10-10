package com.smart.chapter5.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * UserServiceFactoryBean
 * Created by zziaa on 2017/10/10.
 */
@Component
public class UserServiceFactoryBean implements BeanFactoryPostProcessor{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        // 1、将ConfigurableListableBeanFactory转化为DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) bf;
        // 2、通过BeanDefinitionBuilder创建Bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);
        // 3、设置属性userDao，此属性引用已经定义的bean:userDao
        beanDefinitionBuilder.addPropertyReference("userDao", "userDao");
        // 4、注册bean定义
        beanFactory.registerBeanDefinition("userService1", beanDefinitionBuilder.getRawBeanDefinition());
        // 5、直接注册一个Bean实例
        beanFactory.registerSingleton("userService2", new UserService());
    }
}
