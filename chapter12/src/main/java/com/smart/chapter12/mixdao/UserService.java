package com.smart.chapter12.mixdao;

import com.smart.chapter12.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/17 11:33.
 */
@Service
public class UserService extends BaseService {
    private HibernateTemplate hibernateTemplate;
    private ScoreService scoreService;

    public void logon(String userName) {
        // 1、通过Hibernate技术访问数据
        System.out.println("before updateLastLogonTime()...");
        updateLastLogonTime(userName);
        System.out.println("after updateLastLogonTime()...");

        // 2、通过JDBC技术访问数据
        System.out.println("before scoreService.addScore()...");
        scoreService.addScore(userName, 20);
        System.out.println("after scoreService.addScore()...");
    }

    public void updateLastLogonTime(String userName) {
        User user = hibernateTemplate.get(User.class, userName);
        user.setLastLogonTime(System.currentTimeMillis());
        hibernateTemplate.update(user);

        // 3、这句话很重要，请看下文分析
        hibernateTemplate.flush();
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
}
