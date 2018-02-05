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
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1", "jgroup1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity(new TriggerKey("trigger1", "tgroup1"))
            .startAt(DateBuilder.evenMinuteDateAfterNow()).withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(5, 2))
            .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }

    @Test
    public void test() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job1", "jgroup1").build();

        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("job1", "jgroup1")
            .startNow()
            .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(0, 2))
            .build();


        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.addJob(jobDetail, true);
        scheduler.scheduleJob(trigger);
        scheduler.start();
    }
}
