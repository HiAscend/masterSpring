package com.smart.chapter15.cache.cachegroup;

import com.smart.chapter15.cache.domain.User;

/**
 * Visitor
 *
 * @author ascend
 * @date 2017/12/03 19:19
 */
public class Visitor extends User {
    public Visitor(String userId, String userName) {
        super(userId, userName);
    }
}
