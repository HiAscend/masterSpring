package com.smart.chapter14.service;

import com.smart.chapter14.domain.Forum;
import com.smart.chapter14.service.mybatis.BbtForumSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * BbtForumServiceTest
 *
 * @author ascend
 * @date 2017/11/29 15:52.
 */
@ContextConfiguration(locations = {"classpath:applicationContext-mybatis.xml"})
@Transactional
public class BbtForumServiceTest extends AbstractTransactionalTestNGSpringContextTests{
    @Autowired
    private BbtForumSerive bbtForumSerive;

    @Test
    public void test() {
        Forum forum = bbtForumSerive.getForum(1);
        System.out.println("forum = " + forum);
    }

    @Test
    public void test2() {
        long forumNum = bbtForumSerive.getForumNum();
        System.out.println("forumNum = " + forumNum);
    }
}
