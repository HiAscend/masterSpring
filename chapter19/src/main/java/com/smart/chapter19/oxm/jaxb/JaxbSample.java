package com.smart.chapter19.oxm.jaxb;

import com.smart.chapter19.domain.LoginLog;
import com.smart.chapter19.domain.User;

import java.util.GregorianCalendar;

/**
 * JaxbSample
 *
 * @author ascend
 * @date 2018/7/12 15:08.
 */
public class JaxbSample {
    public static User getUser(){
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.1.91");
        log1.setLoginDate(new GregorianCalendar());
        LoginLog log2 = new LoginLog();
        log2.setIp("192.168.1.92");
        log2.setLoginDate(new GregorianCalendar());
        LoginLog log3 = new LoginLog();
        log3.setIp("192.168.1.93");
        log3.setLoginDate(new GregorianCalendar());
        User user = new User();
        user.setUserName("jaxb");
        User.Logs logs = new User.Logs();
        logs.getLoginLog().add(log1);
        logs.getLoginLog().add(log2);
        logs.getLoginLog().add(log3);
        user.setLogs(logs);
        return user;
    }
}
