package com.smart.chapter18.dao;

import com.smart.chapter18.domain.LoginLog;
import org.springframework.stereotype.Repository;

/**
 * LoginLogDao
 *
 * @author ascend
 * @date 2018/5/2 15:28.
 */
@Repository
public class LoginLogDao extends BaseDao<LoginLog> {
    /**
     * 日志保存
     * @param loginLog 日志信息
     */
    @Override
    public void save(LoginLog loginLog) {
        getHibernateTemplate().save(loginLog);
    }
}
