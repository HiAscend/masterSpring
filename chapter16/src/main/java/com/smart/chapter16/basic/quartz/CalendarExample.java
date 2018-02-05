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
        Date date = TriggerUtils.getDateOf(0, 0, 10, 1, 4);
        Date date = TriggerUtils.(0, 0, 10, 1, 4);
        JobDetail job = new JobDetail("job1", "group1", SimpleJob.class);
        SimpleTrigger trigger = new SimpleTrigger("trigger1", "group1", date, null, SimpleTrigger.REPEAT_INDEFINITELY, 60L * 60L * 1000L);
        trigger.setCalendarName("holidays");
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

    }
}
