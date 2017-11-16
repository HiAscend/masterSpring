package com.smart.chapter12.mixlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MixLayerUserService
 *
 * @author ascend
 * @date 2017/11/16 15:31.
 */
// 1、将POJO类通过注解变成Spring MVC的Controller
@Controller
public class MixLayerUserService {
    private JdbcTemplate jdbcTemplate;

    // 3、通过springMVC注解映射成为处理HTTP请求的函数，同时作为一个拥有事务性的方法
    @RequestMapping(path = "/logon.do")
    @Transactional
    public String logon(String userName, String password) {
        System.out.println("MixLayerUserService.logon");
        if (isRightUser(userName, password)) {
            String sql = "update t_user set score=score+? where user_name=?";
            jdbcTemplate.update(sql, 20, userName);
            return "success";
        } else {
            return "fail";
        }
    }

    private boolean isRightUser(String userName, String password) {
        // do sth
        return true;

    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
