package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.assertEquals;

/**
 * UserServiceTest
 * Created by ascend on 2017/8/21 13:53.
 */
@ContextConfiguration("classpath:smart-context.xml")    //启动Spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{
    private UserService userService;

    @Test
    public void testHasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "111111");
        Assert.assertTrue(b1);
        Assert.assertTrue(!b2);
    }

    @Test
    public void testFindUserByUserName() {
        User user = userService.findUserByUserName("admin");
        assertEquals(user.getUserName(), "admin");
        for(int i =0; i< 100;i++) {
            user = userService.findUserByUserName("admin");
            assertEquals(user.getUserName(), "admin");
        }
    }

    @Test
    @Commit
    public void testLoginSuccess() {
        User user = userService.findUserByUserName("admin");
        user.setCredits(0);
        user.setUserName("admin");
        user.setLastIp("192.168.12.7");
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
    }

    //注入Spring容器中的Bean
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
