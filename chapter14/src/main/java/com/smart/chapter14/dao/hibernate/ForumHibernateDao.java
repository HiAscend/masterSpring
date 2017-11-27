package com.smart.chapter14.dao.hibernate;

import com.smart.chapter14.domain.Forum;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ForumHibernateDao
 *
 * @author ascend
 * @date 2017/11/27 15:27.
 */
@Repository
public class ForumHibernateDao extends BaseDao{
    public void addForum(Forum forum) {
        getHibernateTemplate().save(forum);
    }

    public void updateForum(Forum forum) {
        getHibernateTemplate().update(forum);
    }

    public Forum getForum(int forumId) {
        return getHibernateTemplate().get(Forum.class, forumId);
    }

    public long getForumNum() {
        Object object = getHibernateTemplate().iterate("select count(f.forumId) from Forum f").next();
        return (long) object;
    }

    public long getForumNum2() {
        Long forumNum = getHibernateTemplate().execute(new HibernateCallback<Long>() {
            @Override
            public Long doInHibernate(Session session) throws HibernateException {
                Object object = session.createQuery("select count(f.forumId) from Forum f").list().iterator().next();
                return (Long) object;
            }
        });
        return forumNum;
    }

    public List<Forum> findForumByName(String forumName) {
        return (List<Forum>) getHibernateTemplate().find("from Forum f where f.forumName like ?", forumName+"%");
    }
}
