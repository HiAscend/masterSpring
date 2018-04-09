package com.smart.chapter17.web;

import com.smart.chapter17.UserService;
import com.smart.chapter17.domain.Address;
import com.smart.chapter17.domain.User;
import com.smart.chapter17.domain.UserEditor;
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
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * UserController
 *
 * @author ascend
 * @date 2018/03/07 22:30
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = "myUser")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        LOG.debug("UserController.initBinder...");
        binder.registerCustomEditor(User.class, new UserEditor());
        // binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        // binder.addValidators(new UserValidator());
        // 两者的意义不同，addValidator 则会继续使用jsr303进行校验，setValidator则不会使用注解校验，即使添加上@Valid
        // binder.setValidator(new UserValidator());
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
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/handle511")
    public ResponseEntity<Address> handle511() {
        LOG.debug("UserController.handle511...");
        Address address = new Address();
        address.setTel("10086");
        address.setZoneCode("100000");
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @RequestMapping(path = "/handle61")
    public String handle61(@ModelAttribute("user") User user) {
        user.setUserId("10000");
        return "/user/createSuccess";
    }

    // 方法级别上的@ModelAttribute, 并将方法的返回值添加到模型中

    @ModelAttribute(value = "myUser")
    public User getUser() {
        User user = new User();
        user.setUserId("100");
        user.setUserName("modelAttribute");
        user.setPassword("123456");
        return user;
    }

    /**
     * 由于handle62除方法使用了入参级的@ModelAttribute注解，且属性名和上面的@ModelAttribute的属性名相同，这时springMVC会将上面的模型先赋值给
     * 本方法的user，然后再根据http请求对user进行填充覆盖，得到一个整合版本的user对象
     *
     * @param user User
     * @return String
     */
    @RequestMapping(path = "/handle62")
    public String handle62(@ModelAttribute("myUser") User user) {
        user.setUserName("handle62");
        return "/user/showUser";
    }

    @RequestMapping(path = "/handle63")
    public String handle63(ModelMap modelMap) {
        modelMap.addAttribute("testAttr", "value1");
        User user = (User) modelMap.get("myUser");
        user.setUserName("handle63");
        return "/user/showUser";
    }

    @RequestMapping(path = "/handle71")
    public String handle71(@ModelAttribute("myUser") User user) {
        user.setUserName("handle71");
        return "redirect:/user/handle72.html";
    }

    @RequestMapping(path = "/handle72")
    public String handle72(ModelMap modelMap, SessionStatus sessionStatus) {
        User user = (User) modelMap.get("myUser");
        if (Objects.nonNull(user)) {
            user.setUserName("handle72");
            // 让spring mvc清楚本处理器对应的会话属性
            sessionStatus.setComplete();
        }
        modelMap.addAttribute("user", user);
        return "/user/showUser";
    }

    @RequestMapping(path = "/handle81")
    public String handle81(@RequestParam("user") User user, ModelMap modelMap) {
        modelMap.put("user", user);
        return "/user/showUser";
    }

    @RequestMapping(path = "/handle82")
    public String handle82(@ModelAttribute("user") User user) {
        return "/user/showUser";
    }

    @RequestMapping(path = "/handle821")
    public String handle821(Address address) {
        LOG.debug("address:{}", address);
        return "/user/showUser";
    }

    @RequestMapping(path = "/handle91")
    public String handle91(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/register3";
        }else {
            return "/user/showUser";
        }
    }

    @RequestMapping(path = "/handle92")
    public String handle92(@ModelAttribute("user") User user, BindingResult bindingResult) {
        // 使用校验器工具类进行校验
        ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "userName", "required");
        /*if ("aaa".equalsIgnoreCase(user.getUserName())) {
            bindingResult.rejectValue("userName", "reserved");
        }*/
        if (bindingResult.hasErrors()) {
            return "/user/register4";
        }else {
            return "/user/showUser";
        }
    }

    @RequestMapping(path = "/showUserList")
    public String showUserList(ModelMap mm) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        mm.addAttribute("userList", userList);
        mm.addAttribute("car", "benz");
        return "user/userList";
    }

    @RequestMapping(path = "/showUserListByFtl")
    public String showUserListInFtl(ModelMap mm) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListFtl";
    }

    @RequestMapping(path = "/showUserListByXlsx")
    public String showUserListInExcel(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListExcel";
    }


    @RequestMapping(path = "/showUserListByPdf")
    public String showUserListInPdf(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListPdf";
    }

    @RequestMapping(path = "/showUserListByXml")
    public String showUserListInXml(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListXml";
    }

    @RequestMapping(path = "/showUserListByJson")
    public String showUserListInJson(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListJson";
    }

    @RequestMapping(path = "/showUserListByXlsx1")
    public String showUserListInExcel1(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListExcel_1";
    }


    @RequestMapping(path = "/showUserListByPdf1")
    public String showUserListInPdf1(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListPdf_1";
    }

    @RequestMapping(path = "/showUserListByXml1")
    public String showUserListInXml1(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListXml_1";
    }

    @RequestMapping(path = "/showUserListByJson1")
    public String showUserListInJson1(ModelMap modelMap) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, Calendar.FEBRUARY, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        modelMap.addAttribute("userList", userList);
        return "userListJson_1";
    }
}
