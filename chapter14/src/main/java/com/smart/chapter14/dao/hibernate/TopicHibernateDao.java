package com.smart.chapter14.dao.hibernate;

import com.smart.chapter14.domain.Topic;
import org.springframework.stereotype.Repository;

/**
 * TopicHibernateDao
 *
 * @author ascend
 * @date 2017/11/27 15:54.
 */
@Repository
public class TopicHibernateDao extends BaseDao {
    public void addTopic(Topic topic) {
        getHibernateTemplate().save(topic);
    }

    public Topic getTopicById(int topicId) {
        return getHibernateTemplate().get(Topic.class, topicId);
    }
}
