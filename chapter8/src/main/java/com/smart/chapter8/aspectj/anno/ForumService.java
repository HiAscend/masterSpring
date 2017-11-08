package com.smart.chapter8.aspectj.anno;

/**
 * ForumService
 *
 * @author ascend
 * @date 2017/11/8 15:15.
 */
public class ForumService {
    @NeedTest
    public void deleteForum(int forumId) {
        System.out.println("删除论坛模块：" + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId) {
        System.out.println("删除论坛主题：" + postId);
    }
}
