package com.smart.chapter14.dao.hibraw;

import com.smart.chapter14.domain.Topic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * TopicHibernateDao
 *
 * @author ascend
 * @date 2017/11/28 11:01.
 */
@Repository
public class TopicHibernateDao {
    public SessionFactory sessionFactory;

    public void addTopic(Topic topic) {
        sessionFactory.getCurrentSession().save(topic);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
