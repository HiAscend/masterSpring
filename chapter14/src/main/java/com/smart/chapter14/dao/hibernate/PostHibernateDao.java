package com.smart.chapter14.dao.hibernate;

import com.smart.chapter14.domain.Post;
import org.springframework.stereotype.Repository;

/**
 * PostHibernateDao
 *
 * @author ascend
 * @date 2017/11/27 15:52.
 */
@Repository
public class PostHibernateDao extends BaseDao{
    public void addPost(Post post) {
        getHibernateTemplate().save(post);
    }

    public Post getPost(int postId) {
        return getHibernateTemplate().get(Post.class, postId);
    }
}
