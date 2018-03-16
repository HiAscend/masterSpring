package com.smart.chapter17.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * User
 *
 * @author ascend
 * @date 2018/03/08 21:55
 */
@XStreamAlias("message")
public class User {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String userId;
    @XStreamAsAttribute
    private String userName;
    @XStreamAsAttribute
    private String password;
    @XStreamAsAttribute
    private String realName;

    @XStreamOmitField
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
