package com.smart.chapter18.dao;

import com.smart.chapter18.domain.Post;
import org.springframework.stereotype.Repository;

/**
 * PostDao
 *
 * @author ascend
 * @date 2018/5/2 15:20.
 */
@Repository
public class PostDao extends BaseDao<Post> {
    private static final String GET_PAGED_POSTS = "from Post where topic.topicId =? order by createTime desc";

    private static final String DELETE_TOPIC_POSTS = "delete from Post where topic.topicId=?";

    public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
        return pagedQuery(GET_PAGED_POSTS, pageNo, pageSize, topicId);
    }

    /**
     * 删除主题下的所有帖子
     *
     * @param topicId 主题ID
     */
    public void deleteTopicPosts(int topicId) {
        getHibernateTemplate().bulkUpdate(DELETE_TOPIC_POSTS, topicId);
    }
}
