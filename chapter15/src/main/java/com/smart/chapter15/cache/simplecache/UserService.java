package com.smart.chapter15.cache.simplecache;

import com.smart.chapter15.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/30 11:44.
 */
@Service
public class UserService {
    /**
     * 使用一个名为users的缓存
     */
    @Cacheable(cacheNames = {"users"})
    public User getUserById(String userId) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        System.out.println("real query user." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        return new User(userId);
    }
}
