package com.smart.chapter15.cache.cachegroup;

import com.smart.chapter15.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/12/03 19:19
 */
@Service(value = "cacheGroupUserService")
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    {
        userMap.put(1, new Member("1", "w1"));
        userMap.put(2, new Visitor("2", "w2"));
    }

    @Caching(cacheable = {
        @Cacheable(cacheNames = {"members"}, condition = "#user instanceof T(com.smart.chapter15.cache.cachegroup.Member)"),
        @Cacheable(cacheNames = {"visitors"}, condition = "#user instanceof T(com.smart.chapter15.cache.cachegroup.Visitor)")
    })
    public User getUser(User user) {
        return userMap.get(Integer.valueOf(user.getUserId()));
    }
}
