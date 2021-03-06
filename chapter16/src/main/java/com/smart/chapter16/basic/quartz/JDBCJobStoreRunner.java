package com.smart.chapter16.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

/**
 * JDBCJobStoreRunner
 *
 * @author ascend
 * @date 2018/1/19 17:28.
 */
public class JDBCJobStoreRunner {
    public static void main(String[] args) {
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            // 获取调度器中所有的触发器组
            List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
            // 重新恢复在tgroup1组中名为trigger1_1的触发器的运行
            for (String triggerGroupName : triggerGroupNames) {
//                String[] triggers = scheduler.getTriggerNames(triggerGroupName);
                List<String> jobGroupNames = scheduler.getJobGroupNames();
                for (String jobGroupName : jobGroupNames) {
                    Trigger trigger = scheduler.getTrigger(new TriggerKey(jobGroupName, triggerGroupName));
                    if (trigger instanceof SimpleTrigger && trigger.getDescription().equals("tgroup1.trigger1_1")) {
                        scheduler.rescheduleJob(new TriggerKey(jobGroupName, triggerGroupName), trigger);
                    }
                }
                /*for (String trigger1 : triggers) {
                    Trigger trigger = scheduler.getTrigger(trigger1, triggerGroupName);
                    if (trigger instanceof SimpleTrigger && trigger.getFullName().equals("tgroup1.trigger1_1")) {
                        scheduler.rescheduleJob(trigger1, triggerGroupName, trigger);
                    }
                }*/
            }
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
