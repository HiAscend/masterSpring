package com.smart.chapter13.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.testng.annotations.Test;

/**
 * Forum
 *
 * @author ascend
 * @date 2017/11/22 15:58.
 */
public class Forum {
    private int forumId;
    private String forumName;
    private String forumDesc;

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

    @Test
    public void test() {
        Forum forum = new Forum();
        forum.setForumId(1);
        forum.setForumName("windows10");
        forum.setForumDesc("it is interesting");
        System.out.println("forum = " + forum);
    }
}
