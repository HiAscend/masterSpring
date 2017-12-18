package com.smart.chapter16.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * CronTriggerRunner
 *
 * @author ascend
 * @date 2017/12/18 15:01.
 */
public class CronTriggerRunner {
    public static void main(String[] args) {
        try {
            JobDetail jobDetail = new JobDetail("job1_2", "jgroup1", SimpleJob.class);
            CronTrigger cronTrigger = new CronTrigger("trigger1_2", "tgroup1");
            CronExpression cronExpression = new CronExpression("0/4 * * * * ?");
            cronTrigger.setCronExpression(cronExpression);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();

            // sleep ?
        } catch (ParseException | SchedulerException e) {
            e.printStackTrace();
        }
    }
}
