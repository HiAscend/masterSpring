package com.smart.chapter14.service.hibernate;

import com.smart.chapter14.dao.hibernate.ForumHibernateDao;
import com.smart.chapter14.dao.hibernate.PostHibernateDao;
import com.smart.chapter14.dao.hibernate.TopicHibernateDao;
import com.smart.chapter14.domain.Forum;
import com.smart.chapter14.domain.Post;
import com.smart.chapter14.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * BbtForumSerive
 *
 * @author ascend
 * @date 2017/11/28 10:11.
 */
@Transactional
@Service
public class BbtForumSerive {
    private ForumHibernateDao forumHibernateDao;
    private TopicHibernateDao topicHibernateDao;
    private PostHibernateDao postHibernateDao;

    public void addForum(Forum forum) {
        forumHibernateDao.addForum(forum);
    }

    public void addTopic(Topic topic) {
        topicHibernateDao.addTopic(topic);
    }

    public void addPost(Post post) {
        postHibernateDao.addPost(post);
    }

    public Forum getForum(int forumId) {
        return forumHibernateDao.getForum(forumId);
    }

    public void updateForum(Forum forum) {
        forumHibernateDao.updateForum(forum);
    }

    public long getForumNum() {
        return forumHibernateDao.getForumNum();
    }

    public List<Forum> findForumByName(String forumName) {
        return forumHibernateDao.findForumByName(forumName);
    }

    public Post getPost(int postId) {
        return postHibernateDao.getPost(postId);
    }

    @Autowired
    public void setForumHibernateDao(ForumHibernateDao forumHibernateDao) {
        this.forumHibernateDao = forumHibernateDao;
    }

    @Autowired
    public void setTopicHibernateDao(TopicHibernateDao topicHibernateDao) {
        this.topicHibernateDao = topicHibernateDao;
    }

    @Autowired
    public void setPostHibernateDao(PostHibernateDao postHibernateDao) {
        this.postHibernateDao = postHibernateDao;
    }
}
