package com.smart.chapter16.basic.timer;

import java.util.Date;
import java.util.TimerTask;

/**
 * SimpleTimerTask
 *
 * @author ascend
 * @date 2018/02/06 20:57
 */
public class SimpleTimerTask extends TimerTask {
    private int count = 0;

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        System.out.println("execute task.");
        // 获取本次安排执行的时间点
        Date exeTime = new Date(scheduledExecutionTime());
        System.out.println("本次任务安排执行时间点为：" + exeTime);
        // 在任务执行10次后主动退出
        if (++count > 10) {
            cancel();
        }
    }
}
