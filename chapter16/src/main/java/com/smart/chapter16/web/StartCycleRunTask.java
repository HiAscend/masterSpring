package com.smart.chapter16.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * StartCycleRunTask
 *
 * @author ascend
 * @date 2018/03/03 9:48
 */
public class StartCycleRunTask implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(StartCycleRunTask.class);

    private Timer timer;

    /**
     * 该方法在web容器启动的时候执行
     *
     * @param servletContextEvent ServletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.debug("web app is tarting...");
        // 创建一个Timer， 在Timer内部自动创建一个背景线程
        timer = new Timer();
        TimerTask task = new SimpleTimerTask();
        // 注册一个每隔5秒执行一次的任务
        timer.schedule(task, 1000L, 5000L);

    }

    /**
     * 该方法在容器关闭的时候执行
     *
     * @param servletContextEvent ServletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.debug("webapp is closing ...");
    }
}

class SimpleTimerTask extends TimerTask {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleTimerTask.class);

    private int count;

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} execute task...{}", (++count), LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }
}
