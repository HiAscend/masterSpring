package com.smart.chapter14.dao.hibraw;

import com.smart.chapter14.domain.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * PostHibernateDao
 *
 * @author ascend
 * @date 2017/11/28 11:02.
 */
@Repository
public class PostHibernateDao {
    private SessionFactory sessionFactory;

    public void addPost(Post post) {
        sessionFactory.getCurrentSession().save(post);
    }

    public Post getPost(int postId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
