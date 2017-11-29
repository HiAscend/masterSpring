package com.smart.chapter14.dao.hibernate;

import com.smart.chapter14.dao.hibraw.ForumHibernateDao;
import com.smart.chapter14.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * TestRawApiHibernateDao
 *
 * @author ascend
 * @date 2017/11/29 14:51.
 */
@ContextConfiguration(locations = {"classpath:applicationContext-hbt-raw.xml"})
@Transactional
public class TestRawApiHibernateDao extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private ForumHibernateDao forumHibernateDao;

    @Test
    public void testAllMethod() {
        Forum forum = forumHibernateDao.getForum(1);
        Assert.assertNotNull(forum, "have the forum whose forumId is 1");
        List<Forum> list = forumHibernateDao.findForumByName("forum");
        Assert.assertTrue(list.size() > 0);
    }
}
