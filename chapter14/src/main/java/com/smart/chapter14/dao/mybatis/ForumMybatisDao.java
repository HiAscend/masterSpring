package com.smart.chapter14.dao.mybatis;

import com.smart.chapter14.domain.Forum;

import java.util.List;

/**
 * ForumMybatisDao
 *
 * @author ascend
 * @date 2017/11/28 13:58.
 */
public interface ForumMybatisDao {
    void addForum(Forum forum);

    void updateForum(Forum forum);

    Forum getForum(int forumId);

    long getForumNum();

    List<Forum> findForumByName(String forumName);
}
