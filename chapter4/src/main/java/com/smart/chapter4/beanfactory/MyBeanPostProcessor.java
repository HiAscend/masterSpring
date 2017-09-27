package com.smart.chapter4.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Objects;

/**
 * MyBeanPostProcessor
 * Created by ascend on 2017/9/27 11:35.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "car")) {
            Car car = (Car) bean;
            if (Objects.equals(car, null)) {
                System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization，颜色为空，设置为黑色");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "car")) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("MyBeanPostProcessor.postProcessAfterInitialization，速度太高，将maxSpeed调整为200");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
