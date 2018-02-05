package com.smart.chapter16.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;

/**
 * MyJob
 *
 * @author ascend
 * @date 2018/02/04 21:21
 */
public class MyJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Integer size = jobDataMap.getIntegerFromString("size");

        ApplicationContext applicationContext = (ApplicationContext) jobDataMap.get("applicationContext");
        System.out.println("size = " + size);
        // 对JobDataMap所做的更改是否会被持久话取决于任务的类型
        jobDataMap.put("size", size + "0");
        // sth

        int count = jobDataMap.getInt("count");
        System.out.println("count = " + count);

    }
}
