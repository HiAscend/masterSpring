package com.smart.chapter13.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * TopicDaoTest
 *
 * @author ascend
 * @date 2017/11/23 16:04.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TopicDaoTest extends AbstractTransactionalTestNGSpringContextTests {
    private TopicDao topicDao;

    @Test
    public void testGetTopicRowSet() throws Exception {
        SqlRowSet topicRowSet = topicDao.getTopicRowSet(1);

        // 此时数据连接已经断开
        while (topicRowSet.next()) {
            System.out.println(topicRowSet.getString("topic_id"));
        }
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }
}
