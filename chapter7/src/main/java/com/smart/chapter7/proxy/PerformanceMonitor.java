package com.smart.chapter7.proxy;

/**
 * PerformanceMonitor
 *
 * @author ascend
 * @date 2017/10/30 17:14
 */
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<>();

    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance methodPerformance = performanceRecord.get();
        if (methodPerformance == null) {
            methodPerformance = new MethodPerformance(method);
            performanceRecord.set(methodPerformance);
        } else {
            methodPerformance.reset(method);
        }
    }

    public static void end() {
        System.out.println("monitor end");
        MethodPerformance methodPerformance = performanceRecord.get();
        methodPerformance.printPerformance();
    }
}
