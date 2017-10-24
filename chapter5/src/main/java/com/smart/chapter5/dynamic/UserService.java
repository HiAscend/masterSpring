package com.smart.chapter5.dynamic;

/**
 * UserService
 *
 * @author zziaa
 * @date 2017/10/10
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printHello() {
        System.out.println("UserService.printHello");
    }
}
