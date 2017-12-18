package com.smart.chapter16.basic.quartz;

import org.quartz.Calendar;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.GregorianCalendar;

/**
 * CalendarExample
 *
 * @author ascend
 * @date 2017/12/18 15:16.
 */
public class CalendarExample {
    public static void main(String[] args) throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        Calendar holidays = new AnnualCalendar();

        // 五一劳动节
        GregorianCalendar laborDay = new GregorianCalendar();
        laborDay.add(java.util.Calendar.MONTH, 5);
        laborDay.add(java.util.Calendar.DATE, 1);

    }
}
