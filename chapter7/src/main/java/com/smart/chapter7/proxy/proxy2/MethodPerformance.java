package com.smart.chapter7.proxy.proxy2;

/**
 * MethodPerformance
 *
 * @author ascend
 * @date 2017/10/30 17:46
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        reset(serviceMethod);
    }

    public void reset(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        this.end = System.currentTimeMillis();
        long duration = this.end - this.begin;
        System.out.println(serviceMethod + "花费" + duration + "毫秒。");
    }
}
