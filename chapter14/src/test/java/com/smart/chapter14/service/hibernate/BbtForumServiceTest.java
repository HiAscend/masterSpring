package com.smart.chapter14.service.hibernate;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

/**
 * BbtForumServiceTest
 *
 * @author ascend
 * @date 2017/11/29 17:51.
 */
@ContextConfiguration(locations = {"classpath:applicationContext-hbt.xml"})
@Transactional
public class BbtForumServiceTest extends AbstractTransactionalTestNGSpringContextTests{

}
