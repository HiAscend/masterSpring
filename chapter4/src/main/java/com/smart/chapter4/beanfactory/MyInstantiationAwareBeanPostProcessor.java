package com.smart.chapter4.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.util.Objects;

/**
 * MyInstantiationAwareBeanPostProcessor
 * Created by zziaa on 2017/08/29.
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{
    // 1、接口方法：在实例化Bean前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) {
        // 仅对容器中的car bean处理
        if (Objects.equals(beanName, "car")) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    // 2、接口方法：在实例化Bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // 仅对容器中的car bean处理
        if (Objects.equals(beanName, "car")) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    // 3、在设置某个属性的时候调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        // 仅对容器中的car Bean处理，还可以通过pdst入参进行过滤
        if (Objects.equals(beanName, "car")) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
