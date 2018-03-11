package com.smart.chapter17;

import com.smart.chapter17.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author ascend
 * @date 2018/03/08 21:54
 */
@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    public void createUser(User user) {
        LOG.debug("save user.");
    }

    public User getUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("testUserName");
        return user;
    }
}
