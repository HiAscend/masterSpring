package com.smart.chapter15.cache.mycache;

import com.smart.chapter15.cache.domain.User;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/29 22:06
 */
public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        this.cacheManager = new CacheManager<>();
    }

    public User getUserById(String userId) {
        // 首先查询缓存
        User result = cacheManager.getValue(userId);
        if (result != null) {
            System.out.println("get from cache..." + userId);
            return result;
        }
        // 否则到数据库中查询
        result = getFromDB(userId);
        if (result != null) {
            // 将数据库查询的结果更新到缓存中
            cacheManager.addOrUpdateCache(userId, result);
        }
        return result;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("real querying db..." + userId);
        return new User(userId);
    }
}
