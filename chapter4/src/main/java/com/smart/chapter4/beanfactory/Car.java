package com.smart.chapter4.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Car
 * Created by ascend on 2017/8/29 18:03.
 */
//1、管理Bean生命周期的接口
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("Car.Car");
    }

    public void setBrand(String brand) {
        System.out.println("Car.setBrand");
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }

    //2、BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Car.setBeanFactory");
        this.beanFactory = beanFactory;
    }

    //3、BeanNameAware接口方法
    public void setBeanName(String name) {
        System.out.println("Car.setBeanName");
        this.beanName = name;
    }

    //4、InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car.afterPropertiesSet");
    }

    //5、DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("Car.destroy");
    }

    //6、通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("Car.myInit");
        this.maxSpeed = 240;
    }

    //7、通过<bean>的destroy-method属性指定的销毁方法
    public void myDestroy() {
        System.out.println("Car.myDestroy");
    }
}
