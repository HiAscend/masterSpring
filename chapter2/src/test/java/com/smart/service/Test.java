package com.smart.service;

import com.smart.domain.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Test
 * Created by ascend on 2017/8/21 14:56.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:smart-context.xml"})
public class Test {
    private UserService userService;

    //spring的会自动提交
    @org.junit.Test
    public void testLoginSuccess() {
        User user = userService.findUserByUserName("admin");
        user.setCredits(0);
        user.setUserName("admin");
        user.setLastIp("192.168.12.8");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
