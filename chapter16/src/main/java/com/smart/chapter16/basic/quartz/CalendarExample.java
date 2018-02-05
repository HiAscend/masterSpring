package com.smart.chapter16.basic.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.*;
import java.util.Calendar;

/**
 * CalendarExample
 *
 * @author ascend
 * @date 2017/12/18 15:16.
 */
public class CalendarExample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        AnnualCalendar holidays = new AnnualCalendar();

        // 五一劳动节
        GregorianCalendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH, 5);
        laborDay.add(Calendar.DATE, 1);

        // 国庆节
        Calendar nationalDay = new GregorianCalendar();
        nationalDay.add(Calendar.MONTH, 10);
        nationalDay.add(Calendar.DATE, 1);

        // 排除这两个特殊日期
        ArrayList<Calendar> calendarList = new ArrayList<>();
        calendarList.add(laborDay);
        calendarList.add(nationalDay);
        holidays.setDaysExcluded(calendarList);

        // 向Scheduler注册日历
        scheduler.addCalendar("holidays", holidays, false, false);
        // 4月1日上午十点
        Date date = DateBuilder.dateOf(10, 0, 0, 1, 4);
        JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("job1", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("trigger1", "group1")
            .modifiedByCalendar("holidays")
            .startAt(date)
            .endAt(null)
            .withSchedule(SimpleScheduleBuilder.repeatHourlyForever())
            .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();

    }
}
