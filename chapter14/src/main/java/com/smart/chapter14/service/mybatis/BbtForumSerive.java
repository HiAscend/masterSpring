package com.smart.chapter14.service.mybatis;

import com.smart.chapter14.dao.mybatis.ForumMybatisDao;
import com.smart.chapter14.dao.mybatis.PostMybatisDao;
import com.smart.chapter14.dao.mybatis.TopicMybatisDao;
import com.smart.chapter14.domain.Forum;
import com.smart.chapter14.domain.Post;
import com.smart.chapter14.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * BbtForumSerive
 *
 * @author ascend
 * @date 2017/11/29 11:46.
 */
@Transactional
@Service
public class BbtForumSerive {
    private ForumMybatisDao forumMybatisDao;
    private TopicMybatisDao topicMybatisDao;
    private PostMybatisDao postMybatisDao;

    public void addForum(Forum forum) {
        forumMybatisDao.addForum(forum);
    }

    public void addTopic(Topic topic) {
        topicMybatisDao.addTopic(topic);
    }

    public void addPost(Post post) {
        postMybatisDao.addPost(post);
    }

    public Forum getForum(int forumId) {
        return forumMybatisDao.getForum(1);
    }

    public long getForumNum() {
        return forumMybatisDao.getForumNum();
    }

    @Autowired
    public void setForumMybatisDao(ForumMybatisDao forumMybatisDao) {
        this.forumMybatisDao = forumMybatisDao;
    }

    @Autowired
    public void setTopicMybatisDao(TopicMybatisDao topicMybatisDao) {
        this.topicMybatisDao = topicMybatisDao;
    }

    @Autowired
    public void setPostMybatisDao(PostMybatisDao postMybatisDao) {
        this.postMybatisDao = postMybatisDao;
    }
}
