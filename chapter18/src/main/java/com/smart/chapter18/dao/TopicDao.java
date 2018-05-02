package com.smart.chapter18.dao;

import com.smart.chapter18.domain.Topic;
import org.springframework.stereotype.Repository;

/**
 * TopicDao
 *
 * @author ascend
 * @date 2018/5/2 15:01.
 */
@Repository
public class TopicDao extends BaseDao<Topic> {
    private static final String GET_BOARD_DIGEST_TOPICS = "from Topic t where t.boardId = ? and digest > 0 order by t.lastPost desc,digest desc";

    private static final String GET_PAGED_TOPICS = "from Topic where boardId = ? order by lastPost desc";

    private static final String QUERY_TOPIC_BY_TITILE = "from Topic  where topicTitle like ? order by lastPost desc";

    /**
     * 获取论坛版块某一页的精华主题帖，按最后回复时间以及精华级别 降序排列
     *
     * @param boardId  论坛板块id
     * @param pageNo   页号
     * @param pageSize 页大小
     * @return 该论坛下一页精华主题
     */
    public Page getBoardDigestTopics(int boardId, int pageNo, int pageSize) {
        return pagedQuery(GET_BOARD_DIGEST_TOPICS, pageNo, pageSize, boardId);
    }

    /**
     * 获取论坛版块分页的主题帖子,不区分精华帖和普通帖子
     *
     * @param boardId  论坛板块id
     * @param pageNo   页号，从1开始。
     * @param pageSize 页大小
     * @return 包含分页信息的Page对象
     */
    public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
        return pagedQuery(GET_PAGED_TOPICS, pageNo, pageSize, boardId);
    }

    /**
     * 根据主题帖标题查询所有模糊匹配的主题帖
     *
     * @param title    标题的查询条件
     * @param pageNo   页号，从1开始。
     * @param pageSize 页大小
     * @return 包含分页信息的Page对象
     */
    public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
        return pagedQuery(QUERY_TOPIC_BY_TITILE, pageNo, pageSize, title);
    }
}
