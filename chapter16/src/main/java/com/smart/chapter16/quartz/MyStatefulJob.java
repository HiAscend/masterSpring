package com.smart.chapter16.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * MyStatefulJob
 *
 * @author ascend
 * @date 2018/02/05 21:22
 */
public class MyStatefulJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getTrigger().getJobDataMap();
        int count = jobDataMap.getInt("count");
        System.out.println("count = " + count);
    }
}
