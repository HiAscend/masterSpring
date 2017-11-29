package com.smart.chapter14.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Topic
 *
 * @author ascend
 * @date 2017/11/27 9:41.
 */
@Entity
@Table(name = "t_topic")
public class Topic implements Serializable {
    @Id
    @Column(name = "topic_id")
    private int topicId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "topic_title")
    private String topicTitle;
    @Column(name = "topic_time")
    private Date topicTime;
    @ManyToOne
    @JoinColumn(name = "forum_id")
    private Forum forum;
    @Column(name = "topic_views")
    private int topicViews;
    @OneToMany(mappedBy = "topic", cascade = {CascadeType.ALL})
    private List<Post> postList;
    @Column(name = "topic_replies")
    private int topicReplies;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public int getTopicViews() {
        return topicViews;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public int getTopicReplies() {
        return topicReplies;
    }

    public void setTopicReplies(int topicReplies) {
        this.topicReplies = topicReplies;
    }
}
