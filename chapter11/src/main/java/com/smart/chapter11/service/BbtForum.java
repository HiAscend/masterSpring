package com.smart.chapter11.service;

import com.smart.chapter11.dao.ForumDao;
import com.smart.chapter11.dao.PostDao;
import com.smart.chapter11.dao.TopicDao;
import com.smart.chapter11.domain.Forum;
import com.smart.chapter11.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * BbtForum
 *
 * @author ascend
 * @date 2017/11/16 9:20.
 */
@Service
@Transactional
public class BbtForum {
    private ForumDao forumDao;
    private TopicDao topicDao;
    private PostDao postDao;

    public void addTopic(Topic topic) {
        topicDao.addTopic(topic);
        postDao.addPost(topic.getPost());
    }

    @Transactional(readOnly = true)
    public Forum getForum(int forumId) {
        return forumDao.getForum(forumId);
    }

    public void updateForum(Forum forum) {
        forumDao.updateForum(forum);
    }

    public int getForumNum() {
        return forumDao.getForumNum();
    }

    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
