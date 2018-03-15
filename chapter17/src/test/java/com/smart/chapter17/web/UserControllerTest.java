package com.smart.chapter17.web;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * UserControllerTest
 *
 * @author ascend
 * @date 2018/03/14 22:14
 */
public class UserControllerTest {

    @SuppressWarnings("Duplicates")
    @Test
    public void testHandle41() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        restTemplate.postForLocation("http://localhost:8080/chapter17/user/handle41.html", form);
    }

    @Test
    public void testHandle42() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle42/{imageId}.html", null, byte[].class, "1233");
        Resource resource = new FileSystemResource("/tmp/image_copy.png");
        FileCopyUtils.copy(response, resource.getFile());
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void testHandle43() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        restTemplate.postForLocation("http://localhost:8080/chapter17/user/handle43.html", form);
    }
}
