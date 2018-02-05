package com.smart.chapter16.service;

/**
 * MyService
 * 唯一的遗憾是不能被持久化，如果希望任务被持久话，则只能创建正规的Quartz的Job实现类
 * @author ascend
 * @date 2018/02/04 21:59
 */
public class MyService {
    public void doJob() {
        System.out.println("MyService.doJob");
    }
}
