package com.smart.chapter7.advice;

import java.sql.SQLException;

/**
 * @author ascend
 */
public class ForumService {
    public void removeForum(int forumId) {
        // do sth...
        throw new RuntimeException("运行异常");
    }

    public void updateForum(Forum forum) throws SQLException {
        // do sth...
        throw new SQLException("数据库更新操作异常");
    }
}
