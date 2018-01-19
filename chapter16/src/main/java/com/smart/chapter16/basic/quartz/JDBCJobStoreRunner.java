package com.smart.chapter16.basic.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

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
            String[] triggerGroupNames = scheduler.getTriggerGroupNames();
            // 重新恢复在tgroup1组中名为trigger1_1的触发器的运行
            for (int i = 0; i < triggerGroupNames.length; i++) {
                String[] triggers = scheduler.getTriggerNames(triggerGroupNames[i]);
                for (int j = 0; j < triggers.length; j++) {
                    Trigger trigger = scheduler.getTrigger(triggers[j], triggerGroupNames[i]);

                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
