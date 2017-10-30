package com.smart.chapter6.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * ApplicatonEventTest
 *
 * @author ascend
 * @date 2017/10/30 11:18
 */
public class ApplicationEventTest {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationEventTest.class);

    @Test
    public void test() {
        LOG.debug("debug level");
    }

    @Test
    public void testSendMail() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/smart/chapter6/event/beans.xml");
        MailSender mailSender = context.getBean("mailSender", MailSender.class);
        mailSender.sendMail("aaa@bbb.com");
    }
}
