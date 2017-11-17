package com.smart.chapter12.multithread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/17 9:58.
 */
@Service
public class UserService extends BaseService {
    private JdbcTemplate jdbcTemplate;
    private ScoreService scoreService;

    public void logon(String userName) {
        System.out.println("before userService.updateLastLogonTime method...");
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime method...");

        // 1、在同一个线程中调用scoreService#addScore(), 将运行在同一个事务中
//        scoreService.addScore(userName, 20);

        // 2、在一个新线程中执行scoreService#addScore(), 将启用一个新事务
        Thread myThread = new MyThread(scoreService, userName, 20);
        myThread.start();
    }

    public void updateLastLogonTime(String userName) {
        String sql = "update t_user set last_logon_time=? where user_name=?";
        jdbcTemplate.update(sql, System.currentTimeMillis(), userName);
    }

    private class MyThread extends Thread{
        private ScoreService scoreService;
        private String userName;
        private int toAdd;
        private MyThread(ScoreService scoreService, String userName, int toAdd) {
            this.scoreService = scoreService;
            this.userName = userName;
            this.toAdd = toAdd;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("before scoreService.addScore method...");
            scoreService.addScore(userName, toAdd);
            System.out.println("after scoreService.addScore method...");
        }
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
