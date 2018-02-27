package com.smart.chapter16.basic.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ExecutorExample
 *
 * @author ascend
 * @date 2018/02/27 19:20
 */
public class ExecutorExample {
    /**
     * 声明一个执行器
     */
    private Executor executor;

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    /**
     * 用执行器执行多个任务
     */
    public void executeTasks() {
        for (int i = 0; i < 6; i++) {
            executor.execute(new SimpleTask("task" + i));
        }
    }

    public static void main(String[] args) {
        ExecutorExample ee = new ExecutorExample();
        ee.setExecutor(Executors.newFixedThreadPool(3));
        ee.executeTasks();
    }
}

class SimpleTask implements Runnable {
    private String taskName;

    public SimpleTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("do " + taskName + " ... in Thread:" + Thread.currentThread().getId());
    }
}