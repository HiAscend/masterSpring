package com.smart.chapter18.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * LoginLog
 *
 * @author zziaa
 * @date 2018/04/22 20:48
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "t_login_log")
public class LoginLog extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_log_id")
    private int loginLogId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "ip")
    private String ip;

    @Column(name = "login_datetime")
    private Date loginTime;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + loginLogId;
        result = 31 * result + (user == null ? 0 : user.hashCode());
        result = 31 * result + (ip == null ? 0 : ip.hashCode());
        result = 31 * result + (loginTime == null ? 0 : loginTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginLog)) {
            return false;
        }
        LoginLog loginLog = (LoginLog) obj;
        return loginLog.loginLogId == this.loginLogId &&
            Objects.equals(loginLog.user, this.user) &&
            Objects.equals(loginLog.ip, this.ip) &&
            Objects.equals(loginLog.loginTime, this.loginTime);
    }
}
