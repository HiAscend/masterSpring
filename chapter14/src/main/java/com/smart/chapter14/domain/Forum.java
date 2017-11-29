package com.smart.chapter14.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Forum
 *
 * @author ascend
 * @date 2017/11/27 9:29.
 */
@Entity
@Table(name = "t_forum")
public class Forum implements Serializable{
    @Id
    @Column(name = "forum_id")
    private int forumId;
    @Column(name = "forum_name")
    private String forumName;
    @Column(name = "forum_desc")
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
        return ReflectionToStringBuilder.toString(this);
    }
}
