package com.smart.chapter14.dao.mybatis;

import com.smart.chapter14.domain.Post;

/**
 * PostMybatisDao
 *
 * @author ascend
 * @date 2017/11/28 13:57.
 */
public interface PostMybatisDao {
    void addPost(Post post);

    Post getPost(int postId);
}
