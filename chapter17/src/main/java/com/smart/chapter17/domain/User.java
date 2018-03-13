package com.smart.chapter17.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * User
 *
 * @author ascend
 * @date 2018/03/08 21:55
 */
public class User {
    private String userId;
    private String userName;
    private String password;
    private String realName;

    private Dept dept;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
