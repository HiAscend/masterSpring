package com.smart.chapter18.dao;

import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * BoardDaoTest
 *
 * @author ascend
 * @date 2018/5/10 16:07.
 */
@SpringApplicationContext(value = {"xiaochun-dao.xml"})
public class BoardDaoTest extends UnitilsTestNG {
    @SpringBean("boardDao")
    private BoardDao boardDao;

}
