package com.smart.chapter17.web;

import com.smart.chapter17.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;

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

    @Test
    public void testHandle44() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle44/{itemId}.html", null, byte[].class, "1233");
        Resource outFile = new FileSystemResource("/tmp/image_copy.png");
        FileCopyUtils.copy(response, outFile.getFile());
    }

    @Test
    public void testHandle51WithXml() {
        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setUserName("tom");
        user.setPassword("123456");
        user.setRealName("汤姆");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_XML);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        // httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, httpHeaders);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8080/chapter17/user/handle51.html", requestEntity, User.class);
        // ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/chapter17/user/handle51.html", HttpMethod.POST, requestEntity, User.class);

        User responseUser = responseEntity.getBody();
        System.out.println("responseUser = " + responseUser);
        Assert.assertNotNull(responseEntity);
        Assert.assertEquals("10086", responseUser.getUserId());
        Assert.assertEquals("tom", responseUser.getUserName());
        Assert.assertEquals("汤姆", responseUser.getRealName());

    }

    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // 创建MarshallingHttpMessageConverter
        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setStreamDriver(new StaxDriver());
        xStreamMarshaller.setAnnotatedClasses(User.class);

        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
        xmlConverter.setMarshaller(xStreamMarshaller);
        xmlConverter.setUnmarshaller(xStreamMarshaller);

        restTemplate.getMessageConverters().add(xmlConverter);

        // 创建MappingJacksonHttpMessageConverter
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonConverter);
        return restTemplate;
    }

    @Test
    public void t() {
        System.out.println(MediaType.APPLICATION_XML);
        System.out.println(MediaType.valueOf("application/xml;UTF-8"));
    }
}
