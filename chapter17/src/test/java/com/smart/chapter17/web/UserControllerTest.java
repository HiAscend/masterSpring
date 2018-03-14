package com.smart.chapter17.web;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

/**
 * UserControllerTest
 *
 * @author ascend
 * @date 2018/03/14 22:14
 */
public class UserControllerTest {
    @Test
    public void testHandle41() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        restTemplate.postForLocation("http://localhost:8080/chapter17/user/handle41.html", form);
    }
}
