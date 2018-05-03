package com.smart.chapter18.service;

import com.smart.chapter18.dao.LoginLogDao;
import com.smart.chapter18.dao.UserDao;
import com.smart.chapter18.domain.LoginLog;
import com.smart.chapter18.domain.User;
import com.smart.chapter18.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        User u = getUserByUserName(user.getUserName());
        if (Objects.nonNull(u)) {
            throw new UserExistException("用户名已经存在");
        } else {
            user.setCredit(100);
            user.setUserType(User.NORMAL_USER);
            userDao.save(user);
        }
    }

    /**
     * 更新用户
     * @param user User
     */
    public void upate(User user) {
        userDao.update(user);
    }

    /**
     * 根据用户名查询User对象，精确查找
     *
     * @param userName 用户名
     * @return User
     */
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    /**
     * 根据userId加载User对象
     * @param userId int
     * @return User
     */
    public User getUserById(int userId) {
        return userDao.get(userId);
    }

    /**
     * 将用户锁定，锁定的用户不能够登录
     * @param userName 将要锁定的用户
     */
    public void lockUser(String userName) {
        User user = getUserByUserName(userName);
        if (Objects.nonNull(user)) {
            user.setLocked(User.USER_LOCK);
            userDao.update(user);
        }
    }

    /**
     * 解除用户的锁定
     * @param userName 解除锁定的用户
     */
    public void unLockUser(String userName) {
        User user = getUserByUserName(userName);
        if (Objects.nonNull(user)) {
            user.setLocked(User.USER_UNLOCK);
            userDao.update(user);
        }
    }

    /**
     * 根据用户名为条件，执行模糊查询操作
     * @param userName 用户名
     * @return  所有用户名前导匹配的userName的用户
     */
    public List<User> queryUserListByUserName(String userName) {
        return userDao.queryUserListByUserName(userName);
    }

    /**
     * 查询所有的用户
     * @return List
     */
    public List<User> getAllUsers() {
        return userDao.loadAll();
    }

    /**
     * 登陆成功
     * @param user User,登陆成功的用户信息
     */
    public void loginSuccess(User user) {
        user.setCredit(user.getCredit()+5);
        LoginLog log = new LoginLog();
        log.setUser(user);
        log.setIp(user.getLastIp());
        log.setLoginTime(new Date());
        userDao.update(user);
        loginLogDao.save(log);
    }
}
