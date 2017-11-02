package com.smart.chapter7.introduce;

import java.util.concurrent.TimeUnit;

/**
 * @author ascend
 */
public class ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录:"+topicId);
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录:"+forumId);
        try {
            TimeUnit.MILLISECONDS.sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
