package com.smart.chapter13.dao;

import java.sql.Connection;

/**
 * TopicDao
 *
 * @author ascend
 * @date 2017/11/15 16:16.
 */
public class TopicDao {
    private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<>();
}
