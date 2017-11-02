package com.smart.chapter7.introduce;

/**
 * Monitorable
 *
 * @author ascend
 * @date 2017/11/2 10:11.
 */
public interface Monitorable {
    /**
     * 启动和关闭监控
     * @param active boolean
     */
    void setMonitorActive(boolean active);
}
