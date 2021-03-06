package com.smart.chapter17.web;

import com.smart.chapter17.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.transform.Source;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UserControllerTest
 *
 * @author ascend
 * @date 2018/03/14 22:14
 */
public class UserControllerTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserControllerTest.class);

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
    public void test() {
        XStream xStream = new XStream();
        xStream.processAnnotations(User.class);
        // <User><userId/><userName>tom</userName><password>123456</password><realName>汤姆</realName><dept/></User>
        User user = new User();
        user.setUserName("tom");
        user.setPassword("123456");
        user.setRealName("汤姆");
        String s = xStream.toXML(user);
        System.out.println("s = " + s);
    }

    @Test
    public void testHandle51WithXml() {
        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setUserName("tom");
        user.setPassword("123456");
        user.setRealName("汤姆");

        HttpHeaders httpHeaders = new HttpHeaders();
        // 其中xml测试不通过的原因是RestTemplate会根据类路径下的jar加载一些指定的Converter,且会按照加载的顺序发送请求
        httpHeaders.setContentType(MediaType.APPLICATION_XML);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        // httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<>(user, httpHeaders);
        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/chapter17/a/user/handle51", HttpMethod.POST, requestEntity, User.class);

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

        // restTemplate.getMessageConverters().add(xmlConverter);

        // 创建MappingJacksonHttpMessageConverter
        // MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        // restTemplate.getMessageConverters().add(jsonConverter);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();

        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<Source>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());

        messageConverters.add(xmlConverter);

        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Test
    public void testHandle61() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userName", "damon");
        map.add("password", "123456");
        String result = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle61.html", map, String.class);
        LOG.debug("result:{}", result);
    }

    @Test
    public void testHandle62() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userId", "10086");
        String html = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle62.html", map, String.class);
        LOG.debug("html:{}\n", html);
    }

    @Test
    public void testHandle63() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userId", "10086");
        map.add("password", "123456");
        String html = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle63.html", map, String.class);
        LOG.debug("html:{}\n", html);
    }

    @Test
    public void testHandle71() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userName", "tom");
        map.add("password", "123456");
        map.add("age", "45");
        URI uri = restTemplate.postForLocation("http://localhost:8080/chapter17/user/handle71.html", map);
        LOG.debug("uri:{}", uri);
        URI handle72URI = new URI("http://localhost:8080" + uri.toString());
        String html = restTemplate.postForObject(handle72URI, map, String.class);
        LOG.debug("html:{}\n", html);
    }

    @Test
    public void testHandle81() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("user", "tom:1234:tomson");
        String html = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle81.html", form, String.class);
        LOG.debug("html:{}\n", html);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.contains("tom"));
    }

    // 有错误
    @Test
    public void testHandle82() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        form.add("birthday", "2018-03-24");
        form.add("salary", "4,500.00");
        String html = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle82.html", form, String.class);
        Assert.assertNotNull(html);
        Assert.assertTrue(html.contains("tom"));
    }

    @Test
    public void testHandle821() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("tel", "10086");
        form.add("zoneCode", "100000");
        form.add("createTime", "2018-03-24");
        String html = restTemplate.postForObject("http://localhost:8080/chapter17/user/handle821.html", form, String.class);
        System.out.println("");
        LOG.debug("html:{}\n", html);
    }
}
