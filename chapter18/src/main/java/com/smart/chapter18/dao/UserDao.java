package com.smart.chapter18.dao;

import com.smart.chapter18.domain.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 *
 * @author ascend
 * @date 2018/5/2 14:16.
 */
@Repository
public class UserDao extends BaseDao<User> {
    private static final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";

    private static final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";

    /**
     * 根据用户名查询User对象
     *
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null
     */
    public User getUserByUserName(String userName) {
        List<User> userList = (List<User>) getHibernateTemplate().find(GET_USER_BY_USERNAME, userName);
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        } else {
            return userList.get(0);
        }
    }

    /**
     * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
     *
     * @param userName 用户名查询条件
     * @return 用户名前缀匹配的所有User对象
     */
    public List<User> queryUserListByUserName(String userName) {
        return (List<User>) getHibernateTemplate().find(QUERY_USER_BY_USERNAME, userName + "%");
    }
}
