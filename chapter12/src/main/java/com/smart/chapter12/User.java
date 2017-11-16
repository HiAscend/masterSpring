package com.smart.chapter12;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User
 *
 * @author ascend
 * @date 2017/11/16 14:21.
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column(name = "user_name")
    private String userName;
    private String password;
    private int score;
    @Column(name = "last_logon_time")
    private long lastLogonTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getLastLogonTime() {
        return lastLogonTime;
    }

    public void setLastLogonTime(long lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }

    @Override
    public String toString() {
        return "User{" +
            "userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", score=" + score +
            ", lastLogonTime=" + lastLogonTime +
            '}';
    }
}
