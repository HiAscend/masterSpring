package com.smart.chapter16.basic.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * TimerRunner
 *
 * @author ascend
 * @date 2018/02/06 21:06
 */
public class TimerRunner {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new SimpleTimerTask();
        // 在延迟1s后，每5s执行一次任务
        timer.schedule(task, 1000L, 2000L);
    }
}
