package com.smart.chapter18.service;

import com.smart.chapter18.dao.LoginLogDao;
import com.smart.chapter18.dao.UserDao;
import com.smart.chapter18.domain.User;
import com.smart.chapter18.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 * 用户管理服务类，负责查询用户、注册用户、锁定用户等操作
 *
 * @author ascend
 * @date 2018/5/2 15:36.
 */
@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    /**
     * 注册一个新用户，如果用户已经存在将抛出UserExistException的异常
     *
     * @param user User
     * @throws UserExistException 用户已经存在
     */
    public void register(User user) throws UserExistException {
        User u =
    }

    /**
     *
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName) {

    }
}
