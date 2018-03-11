package com.smart.chapter17.web;

import com.smart.chapter17.UserService;
import com.smart.chapter17.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 *
 * @author ascend
 * @date 2018/03/07 22:30
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @RequestMapping(method = {RequestMethod.POST})
    public ModelAndView createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/createSuccess");
        // 相当于在形参列表中，添加@ModelAttribute("user")
//        mav.addObject("user", user);
        return mav;
    }

    // 支持ant风格

    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }

    @RequestMapping("/{userId}")
    public ModelAndView showDetail(@PathVariable("userId") String userId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/showDetail");
        mav.addObject("user", userService.getUserById(userId));
        return mav;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
