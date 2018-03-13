package com.smart.chapter17.web;

import com.smart.chapter17.UserService;
import com.smart.chapter17.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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

    // 1、请求参数按名称匹配的方式绑定到方法入参中，方法返回的字符串代表逻辑视图名

    @RequestMapping(path = "/handle1")
    public String handle1(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          @RequestParam("realName") String realName) {
        return "success";
    }

    // 2、将Cookie值及报文头属性绑定到入参中，方法返回ModelAndView

    @RequestMapping(path = "/handle2")
    public ModelAndView handle2(@CookieValue("JSESSIONID") String sessionId, @RequestHeader("Accept-Language") String acceptLanguage) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("user", new User());
        return mav;
    }

    // 3、请求参数按名称匹配的方式绑定到user的属性中，方法返回的字符串代表逻辑视图名

    @RequestMapping(path = "/handle3")
    public String handle3(User user) {
        return "success";
    }

    // 4、直接将HTTP请求对象传递给处理方法，方法返回的字符串代表逻辑视图名

    @RequestMapping(path = "/handle4")
    public String handle4(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping(path = "/handle11")
    public String handle11(@RequestParam(value = "userName", required = false) String userName,
                           @RequestParam("age") int age) {
        return "success";
    }

    @RequestMapping(path = "/handle12")
    public String handle12(@RequestParam(value = "sessionId", required = false) String sessionId,
                           @RequestParam("age") int age) {
        return "success";
    }

    @RequestMapping(path = "/handle13")
    public String handle13(@RequestHeader("Accept-Encoding") String endcoding,
                           @RequestHeader("Keep-Alive") long keepAlive) {
        return "success";
    }

    @RequestMapping(path = "/handle14")
    public String handle14(User user) {
        LOG.debug("user:{}", user);
        return "success";
    }

    // 使用servlet-api对象作为入参

    @RequestMapping(path = "/handle21")
    public void handle21(HttpServletRequest request, HttpServletResponse response) {
        String userName = WebUtils.findParameterValue(request, "userName");
        LOG.debug("userName:{}", userName);

    }
}
