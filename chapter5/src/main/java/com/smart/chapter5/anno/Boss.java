package com.smart.chapter5.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Boss
 * Created by zziaa on 2017/10/08.
 */
@Component
public class Boss {
    private Car car;

    public Boss() {
        System.out.println("Boss.Boss");
    }

    @Autowired
    public void setCar(Car car) {
        System.out.println("Boss.setCar");
        this.car = car;
    }

    @PostConstruct
    private void init1() {
        System.out.println("Boss.init1");
    }

    @PostConstruct
    private void init2() {
        System.out.println("Boss.init2");
    }

    @PreDestroy
    private void destory1() {
        System.out.println("Boss.destory1");
    }

    @PreDestroy
    private void destory2() {
        System.out.println("Boss.destory2");
    }
}
