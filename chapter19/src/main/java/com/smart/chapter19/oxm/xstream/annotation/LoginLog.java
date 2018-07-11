package com.smart.chapter19.oxm.xstream.annotation;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * LoginLog
 *
 * @author ascend
 * @date 2018/7/10 15:13.
 */
@XStreamAlias("loginLog")
public class LoginLog implements Serializable {
    private static final long serialVersionUID = 5790015514259042515L;
    @XStreamAsAttribute
    @XStreamAlias("id")
    private int loginLogId;
    @XStreamAsAttribute
    private int userId;
    @XStreamAlias("ip")
    private String ip;
    @XStreamAlias("loginDate")
    @XStreamConverter(DateConverter.class)
    private Date loginDate;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
