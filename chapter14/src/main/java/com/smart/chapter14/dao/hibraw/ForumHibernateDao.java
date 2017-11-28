package com.smart.chapter14.dao.hibraw;

import com.smart.chapter14.domain.Forum;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ForumHibernateDao
 *
 * @author ascend
 * @date 2017/11/28 10:52.
 */
@Repository
public class ForumHibernateDao {
    private SessionFactory sessionFactory;

    public void addForum(Forum forum) {
        sessionFactory.getCurrentSession().save(forum);
    }

    public void updateForum(Forum forum) {
        sessionFactory.getCurrentSession().update(forum);
    }

    public Forum getForum(int forumId) {
        return sessionFactory.getCurrentSession().load(Forum.class, forumId);
    }

    public long getForumNum() {
        Object object = sessionFactory.getCurrentSession().createQuery("select count(f.forumId) from Forum f").list().iterator().next();
        return (long) object;
    }

    public List<Forum> findForumByName(String forumName) {
        List list = sessionFactory.getCurrentSession().createQuery("from Forum f where f.forumName like ?")
            .setString(0, forumName + "%")
            .list();
        return list;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
