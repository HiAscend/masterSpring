package com.smart.chapter7.proxy.proxy2;

import java.util.concurrent.TimeUnit;

/**
 * ForumServiceImpl
 *
 * @author ascend
 * @date 2017/10/30 17:14
 */
public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        // 1、开始对该方法进行性能监视
//        PerformanceMonitor.begin("com.smart.chapter7.proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除topic记录：" + topicId);
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 2、结束对该方法的性能监视
//        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        // 1、开始对该方法进行性能监视
//        PerformanceMonitor.begin("com.smart.chapter7.proxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录：" + forumId);
        try {
            TimeUnit.MILLISECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 2、结束对该方法的性能监视
//        PerformanceMonitor.end();
    }
}
