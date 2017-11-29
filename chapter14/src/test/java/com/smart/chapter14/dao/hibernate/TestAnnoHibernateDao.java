package com.smart.chapter14.dao.hibernate;

import com.smart.chapter14.domain.Forum;
import com.smart.chapter14.domain.Post;
import com.smart.chapter14.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * TestAnnoHibernateDao
 *
 * @author ascend
 * @date 2017/11/29 13:56.
 */
@ContextConfiguration(locations = {"classpath:applicationContext-hbt-anno.xml"})
@Transactional
public class TestAnnoHibernateDao extends AbstractTransactionalTestNGSpringContextTests{
    @Autowired
    private ForumHibernateDao forumHibernateDao;
    @Autowired
    private PostHibernateDao postHibernateDao;

    @SuppressWarnings("Duplicates")
    @Test
    public void testAddPost() throws IOException {
        Topic topic = new Topic();
        topic.setTopicId(1);
        Post post = new Post();
        post.setPostId(10);
        post.setPostText("post text...");

        Resource resource = new ClassPathResource("temp.jpg");
        byte[] imageFile = FileCopyUtils.copyToByteArray(resource.getFile());
        post.setPostAttach(imageFile);
        post.setTopic(topic);
        postHibernateDao.addPost(post);
    }

    @Test
    public void testFindForumByName() {
        List<Forum> forums = forumHibernateDao.findForumByName("forum");
        Assert.assertTrue(forums.size() > 0);
    }
}
