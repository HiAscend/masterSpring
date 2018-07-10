package com.smart.chapter19.oxm.xstream.annotation;

import java.io.Serializable;
import java.util.Date;

/**
 * LoginLog
 *
 * @author ascend
 * @date 2018/7/10 15:13.
 */
public class LoginLog implements Serializable {
    private static final long serialVersionUID = 5790015514259042515L;
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
