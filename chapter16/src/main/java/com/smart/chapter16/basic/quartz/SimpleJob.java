package com.smart.chapter16.basic.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * SimpleJob
 *
 * @author ascend
 * @date 2017/12/18 11:50.
 */
public class SimpleJob implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleJob.class);

    public SimpleJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello SimpleJob. time is:" + (LocalDateTime.now()));
    }
}
