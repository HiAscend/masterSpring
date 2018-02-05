package com.smart.chapter16.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * SimpleTriggerRunner
 *
 * @author ascend
 * @date 2017/12/18 13:43.
 */
public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = new JobDetail("job1", "jgroup1", SimpleJob.class);
        SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1", "tgroup1");
        simpleTrigger.setStartTime(new Date());
        simpleTrigger.setRepeatInterval(2000);
        // 重复次数
        simpleTrigger.setRepeatCount(5);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();
    }

    @Test
    public void test() throws SchedulerException {
        JobDetail jobDetail = new JobDetail("job1", "jgroup1", SimpleJob.class);
        SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1", "tgroup1");
        simpleTrigger.setStartTime(new Date());
        simpleTrigger.setRepeatInterval(2000);
        // 重复次数
        simpleTrigger.setRepeatCount(0);
        simpleTrigger.setJobName("job1");
        simpleTrigger.setGroup("jgroup1");

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.addJob(jobDetail, true);
        scheduler.scheduleJob(simpleTrigger);
        scheduler.start();
    }
}
