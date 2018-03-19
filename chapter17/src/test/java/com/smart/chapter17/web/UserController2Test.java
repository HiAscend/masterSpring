package com.smart.chapter17.web;

import org.springframework.web.client.AsyncRestTemplate;
import org.testng.annotations.Test;

/**
 * UserController2Test
 *
 * @author zziaa
 * @date 2018/03/19 22:40
 */
public class UserController2Test {
    @Test
    public void testApi() {
        AsyncRestTemplate template = new AsyncRestTemplate();
        // 调用后立即返回（没有阻塞）
    }
}
