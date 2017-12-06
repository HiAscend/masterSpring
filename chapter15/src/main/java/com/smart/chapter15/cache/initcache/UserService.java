package com.smart.chapter15.cache.initcache;

import com.smart.chapter15.cache.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/12/06 20:38
 */
@Service(value = "initUserService")
public class UserService {
    private Map<Integer, User> users = new HashMap<Integer, User>();

    {
        users.put(1, new User("1", "w1"));
        users.put(2, new User("2", "w2"));
    }

    private CacheManager cacheManager;

    @PostConstruct
    public void setUp() {
        Cache usersCache = cacheManager.getCache("users");
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            usersCache.put(entry.getKey(), entry.getValue());
        }
    }

    @Cacheable(cacheNames = {"users"})
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
