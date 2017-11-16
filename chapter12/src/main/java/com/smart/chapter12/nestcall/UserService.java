package com.smart.chapter12.nestcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/16 17:11.
 */
@Service
public class UserService extends BaseService {
    private JdbcTemplate jdbcTemplate;
    private ScoreService scoreService;


    public void logon(String userName) {
        System.out.println("before userService.updateLastLogonTime...");
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime...");

        System.out.println("before scoreService.addScore...");
        scoreService.addScore(userName, 20);
        System.out.println("after scoreService.addScore...");
    }

    public void updateLastLogonTime(String userName) {
        String sql = "update t_user set last_logon_time=? where user_name=?";
        jdbcTemplate.update(sql, System.currentTimeMillis(), userName);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
}
