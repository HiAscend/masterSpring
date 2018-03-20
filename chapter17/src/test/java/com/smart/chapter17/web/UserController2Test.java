package com.smart.chapter17.web;

import com.smart.chapter17.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.testng.annotations.Test;

/**
 * UserController2Test
 *
 * @author zziaa
 * @date 2018/03/19 22:40
 */
public class UserController2Test {
    private static final Logger LOG = LoggerFactory.getLogger(UserController2Test.class);

    @Test
    public void testApi() throws InterruptedException {
        AsyncRestTemplate template = new AsyncRestTemplate();
        // 1、调用后立即返回（没有阻塞）
        ListenableFuture<ResponseEntity<User>> future = template.getForEntity("http://localhost:8080/chapter17/a/api", User.class);
        // 2、处理服务端响应得异步回调方法
        future.addCallback(new ListenableFutureCallback<ResponseEntity<User>>() {
            @Override
            public void onFailure(Throwable ex) {
                LOG.debug("client failure:", ex);
            }

            @Override
            public void onSuccess(ResponseEntity<User> result) {
                LOG.debug("client get result:{}", result.getBody());
            }
        });
        LOG.debug("no wait");
        // TimeUnit.SECONDS.sleep(15);
    }
}
