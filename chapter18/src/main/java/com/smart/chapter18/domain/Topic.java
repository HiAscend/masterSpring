package com.smart.chapter18.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Topic
 *
 * @author zziaa
 * @date 2018/04/22 17:32
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_topic")
public class Topic extends BaseDomain {
    /**
     * 精华主题帖子
     */
    public static final int DIGEST_TOPIC = 1;
    /**
     * 普通主题帖子
     */
    public static final int NO_DIGEST_TOPIC = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int topicId;

    @Column(name = "topic_title")
    private String topicTitle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "board_id")
    private int boardId;

    @Transient
    private MainPost mainPost = new MainPost();

    @Column(name = "last_post")
    private Date lastPost = new Date();

    @Column(name = "create_time")
    private Date createTime = new Date();

    @Column(name = "topic_views")
    private int views;

    @Column(name = "topic_replies")
    private int replies;

    @Column(name = "digest")
    private int digest = NO_DIGEST_TOPIC;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public MainPost getMainPost() {
        return mainPost;
    }

    public void setMainPost(MainPost mainPost) {
        this.mainPost = mainPost;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getDigest() {
        return digest;
    }

    public void setDigest(int digest) {
        this.digest = digest;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + topicId;
        result = 31 * result + (topicTitle == null ? 0 : topicTitle.hashCode());
        result = 31 * result + (user == null ? 0 : user.hashCode());
        result = 31 * result + boardId;
        result = 31 * result + (mainPost == null ? 0 : mainPost.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return topic.topicId == this.topicId &&
            Objects.equals(topic.topicTitle, this.topicTitle) &&
            Objects.equals(topic.user, this.user) &&
            topic.boardId == this.boardId &&
            Objects.equals(topic.mainPost, this.mainPost);
    }
}
