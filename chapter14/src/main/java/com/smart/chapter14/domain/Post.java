package com.smart.chapter14.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Post
 *
 * @author ascend
 * @date 2017/11/27 9:44.
 */
@Entity
@Table(name = "t_post")
public class Post  implements Serializable {
    @Id
    @Column(name = "post_id")
    private int postId;
    @Column(name = "user_id")
    private int userId;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @Lob
    @Column(name = "post_text")
    private String postText;
    @Lob
    @Column(name = "post_attach")
    private byte[] postAttach;
    @Column(name = "post_time")
    private Date postTime;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public byte[] getPostAttach() {
        return postAttach;
    }

    public void setPostAttach(byte[] postAttach) {
        this.postAttach = postAttach;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
}
