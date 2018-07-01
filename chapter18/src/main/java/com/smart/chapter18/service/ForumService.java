package com.smart.chapter18.service;

import com.smart.chapter18.dao.BoardDao;
import com.smart.chapter18.dao.PostDao;
import com.smart.chapter18.dao.TopicDao;
import com.smart.chapter18.dao.UserDao;
import com.smart.chapter18.domain.Board;
import com.smart.chapter18.domain.MainPost;
import com.smart.chapter18.domain.Topic;
import com.smart.chapter18.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ForumService
 * 论坛管理服务类，对论坛版块、话题、帖子进行管理
 *
 * @author zziaa
 * @date 2018/07/01 9:58
 */
@Service
public class ForumService {
    private TopicDao topicDao;
    private UserDao userDao;
    private BoardDao boardDao;
    private PostDao postDao;

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    /**
     * 发表一个主题帖子,用户积分加 10，论坛版块的主题帖数加 1
     *
     * @param topic Topic
     */
    public void addTopic(Topic topic) {
        Board board = boardDao.get(topic.getBoardId());
        board.setTopicNum(board.getTopicNum() + 1);
        boardDao.save(board);

        //
        topic.getMainPost().setTopic(topic);
        MainPost mainPost = topic.getMainPost();
        mainPost.setCreateTime(new Date());
        mainPost.setUser(topic.getUser());
        mainPost.setPostTitle(topic.getTopicTitle());
        mainPost.setBoardId(topic.getBoardId());
        postDao.save(mainPost);

        User user = topic.getUser();
        user.setCredit(user.getCredit()+ 10);
        userDao.update(user);
    }

}
