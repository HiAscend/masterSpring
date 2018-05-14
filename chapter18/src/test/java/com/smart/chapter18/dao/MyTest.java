package com.smart.chapter18.dao;

import org.testng.annotations.Test;

/**
 * MyTest
 *
 * @author ascend
 * @date 2018/5/14 17:51.
 */
public class MyTest {

    @Test
    public void test() throws ClassNotFoundException {
        System.out.println("true = " + true);
        Class.forName("com.smart.chapter18.dao.MyTest");
        Class.forName("org.hibernate.cfg.AnnotationConfiguration");
    }
}
