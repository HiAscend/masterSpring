package com.smart.chapter12.withouttx.hiber;

import com.smart.chapter12.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 * UserHibernateWithoutTransManagerService
 *
 * @author ascend
 * @date 2017/11/16 14:18.
 */
@Service(value = "hiberService")
public class UserHibernateWithoutTransManagerService {
    private HibernateTemplate hibernateTemplate;

    public void addScore(String userName, int toAdd) {
        User user = hibernateTemplate.get(User.class, userName);
        System.out.println("user = " + user);
        // 以下两条语句取消注释后，由于默认事务管理器不支持数据更改，将报异常
//        user.setScore(user.getScore()+toAdd);
//        hibernateTemplate.update(user);
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter12/withouttx/hiber/hiberWithoutTx.xml");
        UserHibernateWithoutTransManagerService hiberService = context.getBean("hiberService", UserHibernateWithoutTransManagerService.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        BasicDataSource dataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        // 检查数据源autoCommit的设置
        System.out.println("autoCommit:" + dataSource.getDefaultAutoCommit());
//        dataSource.setDefaultAutoCommit(false);
        // 插入一条记录，初始分数为10
        jdbcTemplate.execute("insert into t_user(user_name, password, score, last_logon_time) values('tom', '123456', 10, " + System.currentTimeMillis() + ")");
        // 调用工作在无事务环境下的服务类方法，将分数添加20
        hiberService.addScore("tom", 20);
        // 查看此时用户的分数
        int score = jdbcTemplate.queryForObject("select score from t_user where user_name = 'tom'", Integer.class);
        System.out.println("score = " + score);
        jdbcTemplate.update("delete from t_user where user_name = 'tom'");

    }
}
