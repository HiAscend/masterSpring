package com.smart.chapter16.basic.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * SimpleJob
 *
 * @author ascend
 * @date 2017/12/18 11:50.
 */
public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(jobExecutionContext.getTrigger().getName() + " triggered. time is:" + (LocalDateTime.now()));
    }
}
