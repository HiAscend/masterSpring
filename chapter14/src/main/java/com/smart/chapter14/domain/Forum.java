package com.smart.chapter14.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Forum
 *
 * @author ascend
 * @date 2017/11/27 9:29.
 */
@Entity
@Table(name = "t_forum")
public class Forum {
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
}