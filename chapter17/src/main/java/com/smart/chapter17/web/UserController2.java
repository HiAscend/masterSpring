package com.smart.chapter17.web;

import com.smart.chapter17.UserService;
import com.smart.chapter17.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * UserController2
 * 开发Rest风格的应用程序只需要在xml文件中配置<context:component-scan... 和<mvc:annotation-driven/>
 *
 * @author zziaa
 * @date 2018/03/19 22:28
 */
@RestController
public class UserController2 {
    private static final Logger LOG = LoggerFactory.getLogger(UserController2.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/api")
    public Callable<User> api() {
        LOG.debug("=====hello=====");
        return () -> {
            // 暂停10s
            TimeUnit.SECONDS.sleep(10);
            User user = new User();
            user.setUserId("10010");
            user.setUserName("katherine");
            return user;
        };
    }
}
