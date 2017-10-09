package com.smart.chapter5.conf;

/**
 * LogonService
 * Created by zziaa on 2017/10/09.
 */
public class LogonService {
    private UserDao userDao;
    private LogDao logDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LogDao getLogDao() {
        return logDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void printHelllo() {
        System.out.println("hello!");
    }
}
