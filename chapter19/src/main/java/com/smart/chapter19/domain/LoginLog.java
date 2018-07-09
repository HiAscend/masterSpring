package com.smart.chapter19.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * LoginLog
 *
 * @author zziaa
 * @date 2018/07/09 23:10
 */
public class LoginLog implements Serializable {
    private static final long serialVersionUID = -7152673639413132099L;

    private int loginLogId;
    private int userId;
    private String ip;
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
}
