package com.smart.chapter11.service;

import com.smart.chapter11.ForumTransactional;
import com.smart.chapter11.TopicTransactional;
import com.smart.chapter11.domain.Forum;
import com.smart.chapter11.domain.Topic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MultiForumService
 *
 * @author ascend
 * @date 2017/11/16 11:01.
 */
@Service
public class MultiForumService {
//    @Transactional(value = "forumTxManager")
    @ForumTransactional
    public void addTopic(Topic topic) {
        System.out.println("MultiForumService.addTopic");
    }

//    @Transactional(value = "topicTransactionManager")
    @TopicTransactional
    public void updateForum(Forum forum) {
        System.out.println("MultiForumService.updateForum");
    }
}
