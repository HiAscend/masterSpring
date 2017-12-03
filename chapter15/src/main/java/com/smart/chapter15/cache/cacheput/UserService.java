package com.smart.chapter15.cache.cacheput;

import com.smart.chapter15.cache.domain.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/12/03 18:39
 */
@Service(value = "cachePutUserService")
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    {
        userMap.put(1, new User("1", "cxh"));
        userMap.put(2, new User("2", "lkx"));
        userMap.put(3, new User("3", "wjg"));
    }

    @CachePut(cacheNames = {"users"})
    public User getUser(int id) {
        System.out.println("User with id:" + id + " requested.");
        return userMap.get(id);
    }
}
