package com.smart.chapter12.withouttx.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * UserJdbcWithoutTransManagerService
 *
 * @author ascend
 * @date 2017/11/16 11:39.
 */
@Service(value = "userService")
public class UserJdbcWithoutTransManagerService {
    private JdbcTemplate jdbcTemplate;

    public void addScore(String username, int toAdd) {
        String sql = "update t_user u set u.score=u.score+? where user_name=?";
        jdbcTemplate.update(sql, toAdd, username);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter12/withouttx/jdbc/jdbcWithoutTx.xml");
        UserJdbcWithoutTransManagerService service = context.getBean("userService", UserJdbcWithoutTransManagerService.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        service.setJdbcTemplate(jdbcTemplate);
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        // 检查数据源autoCommit的设置
        System.out.println("autoCommit:" + basicDataSource.getDefaultAutoCommit());
//        basicDataSource.setDefaultAutoCommit(false);
        // 插入一条记录，初始分数为10
        jdbcTemplate.execute("insert into t_user(user_name, password, score, last_logon_time) values('tom', '123456', 10, " + System.currentTimeMillis() + ")");
        // 调用工作在无事务环境下的服务类方法，将分数添加20
        service.addScore("tom", 20);
        // 查看此时用户的分数
        int score = jdbcTemplate.queryForObject("select score from t_user where user_name = 'tom'", Integer.class);
        System.out.println("score = " + score);
        jdbcTemplate.update("delete from t_user where user_name = 'tom'");
    }
}
