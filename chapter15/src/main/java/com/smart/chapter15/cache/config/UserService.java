package com.smart.chapter15.cache.config;

import com.smart.chapter15.cache.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/12/06 20:15
 */
@CacheConfig(cacheNames = {"users"}/*, keyGenerator = "MyKeyGenerator"*/)
public class UserService {
    @Cacheable
    public User findA(User user) {
        return null;
    }

    @Cacheable
    public User findB(User user) {
        return null;
    }
}
