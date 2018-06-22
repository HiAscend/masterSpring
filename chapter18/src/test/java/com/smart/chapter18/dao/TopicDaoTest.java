package com.smart.chapter18.dao;

import com.smart.chapter18.domain.Topic;
import com.smart.chapter18.domain.User;
import com.smart.chapter18.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

/**
 * TopicDaoTest
 *
 * @author ascend
 * @date 2018/6/21 9:39.
 */
public class TopicDaoTest extends BaseDaoTest {
    @SpringBean("topicDao")
    private TopicDao topicDao;

    @Test
    @DataSet(value = {"XiaoChun.SaveTopics.xls"})
    @ExpectedDataSet(value = "XiaoChun.ExpectedTopics.xls")
    @SuppressWarnings(value = {"Duplicates"})
    public void testAddTopic() throws Exception {
        List<Topic> topicList = XlsDataSetBeanFactory.createBeans(TopicDaoTest.class, "XiaoChun.SaveTopics.xls", "t_topic", Topic.class);
        for (Topic topic : topicList) {
            User user = new User();
            user.setUserId(1);
            topic.setUser(user);
            topicDao.save(topic);
        }
    }
}
