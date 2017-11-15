package com.smart.chapter11.domain;

import java.util.Date;

/**
 * Topic
 *
 * @author ascend
 * @date 2017/11/15 17:52.
 */
public class Topic {
    private int topicId;
    private String topicTitle;
    private Date topicTime;
    private Post post;

    private int topicViews;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Date getTopicTime() {
        return topicTime;
    }

    public void setTopicTime(Date topicTime) {
        this.topicTime = topicTime;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }
}
