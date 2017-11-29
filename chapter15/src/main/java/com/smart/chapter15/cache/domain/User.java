package com.smart.chapter15.cache.domain;

import java.io.Serializable;

/**
 * User
 *
 * @author ascend
 * @date 2017/11/29 21:51
 */
public class User implements Serializable{
    private String userId;
    private String userName;
    private int age;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
