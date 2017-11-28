package com.smart.chapter14.dao;

import com.smart.chapter14.domain.Forum;

/**
 * ForumDao
 *
 * @author ascend
 * @date 2017/11/28 10:08.
 */
public class ForumDao extends BaseDao<Forum> {
    public long getForumNum() {
        Object object = getHibernateTemplate().iterate("select count(f.forumId) from Forum f").next();
        return (long) object;
    }
}
