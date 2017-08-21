package com.smart.web;

import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 * Created by ascend on 2017/8/21 16:03.
 */
@RestController
public class LoginController {
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }




    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
