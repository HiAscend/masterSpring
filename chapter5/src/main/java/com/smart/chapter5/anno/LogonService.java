package com.smart.chapter5.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * LogonService
 * Created by zziaa on 2017/10/05.
 */
@Service
public class LogonService {
    @Lazy
    @Qualifier
    private final LogDao logDao;
    private final UserDao userDao;

    @Autowired
    public LogonService(LogDao logDao, @Qualifier("userDao") UserDao userDao) {
        this.logDao = logDao;
        this.userDao = userDao;
    }

}
