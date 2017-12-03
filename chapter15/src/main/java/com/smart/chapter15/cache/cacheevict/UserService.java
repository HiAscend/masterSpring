package com.smart.chapter15.cache.cacheevict;

import com.smart.chapter15.cache.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/12/03 19:10
 */
@Service(value = "cacheEvictUserService")
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    {
        userMap.put(1, new User("1", "cxh"));
        userMap.put(2, new User("2", "lkx"));
        userMap.put(3, new User("3", "wjg"));
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        return userMap.get(id);
    }

    @CacheEvict("users")
    public void removeUser(int id) {
        userMap.remove(id);
    }
}
