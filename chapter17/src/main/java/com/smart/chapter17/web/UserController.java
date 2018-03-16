package com.smart.chapter17.web;

import com.smart.chapter17.UserService;
import com.smart.chapter17.domain.User;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

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
        LOG.debug("userName:{}", userName);
        LOG.debug("password:{}", password);
        LOG.debug("realName:{}", realName);
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
    public String handle21(HttpServletRequest request, HttpServletResponse response) {
        String userName = WebUtils.findParameterValue(request, "userName");
        LOG.debug("userName:{}", userName);
        return "success";
    }

    @RequestMapping(path = "/handle22")
    public ModelAndView handle22(HttpServletRequest request) {
        String userName = WebUtils.findParameterValue(request, "userName");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        mav.addObject("userName", userName);
        return mav;
    }

    @RequestMapping(path = "/handle23")
    public String handle23(HttpSession session) {
        session.setAttribute("sessionId", 1234);
        return "success";
    }

    @RequestMapping(path = "/handle24")
    public String handle24(HttpServletRequest request,
                           @RequestParam("userName") String userName) {
        return "success";
    }

    @RequestMapping(path = "/handle25")
    public String handle25(WebRequest request) {
        String userName = request.getParameter("userName");

        return "success";
    }

    @RequestMapping(path = "/handle31")
    public void handle31(OutputStream os) throws IOException {
        Resource resource = new ClassPathResource("image.png");
        // FileCopyUtils.copy(resource.getInputStream(), os);
        IOUtils.copy(resource.getInputStream(), os);
    }

    // 将请求报文体转换为字符串绑定到requestBody入参中

    // annotation-driven

    @RequestMapping(path = "/handle41")
    public String handle41(@RequestBody String requestBody) {
        LOG.debug("requestBody:{}", requestBody);
        return "success";
    }

    @ResponseBody
    @RequestMapping(path = "/handle42/{imageId}")
    public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException {
        LOG.debug("load image of {}", imageId);
        Resource resource = new ClassPathResource("image.png");
        return IOUtils.toByteArray(resource.getInputStream());
    }

    // 使用HttpEntity 访问请求和报文头的数据

    @RequestMapping(path = "/handle43")
    public String handle43(HttpEntity<String> httpEntity) {
        long contentLength = httpEntity.getHeaders().getContentLength();
        LOG.debug("contentLength:{}", contentLength);
        LOG.debug("body:{}", httpEntity.getBody());
        return "success";
    }


    @RequestMapping(path = "/handle44/{imageId}")
    public ResponseEntity<byte[]> handle44(@PathVariable("imageId") String imageId) throws IOException {
        LOG.debug("load image id:{}", imageId);
        Resource resource = new ClassPathResource("/image.png");
        byte[] fileData = FileCopyUtils.copyToByteArray(resource.getFile());
        return new ResponseEntity<>(fileData, HttpStatus.OK);
    }

    @RequestMapping(path = "/handle51")
    public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
        LOG.debug("contentLength:{}", requestEntity.getHeaders().getContentLength());
        LOG.debug("body:{}", requestEntity.getBody());
        User user = requestEntity.getBody();
        user.setUserId("10086");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
