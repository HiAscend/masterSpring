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
            JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("job1-2", "jgroup1").build();
            Trigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("grigger1_2", "tgroup1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/4 * * * * ?"))
                .build();

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();

            // sleep ?
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
