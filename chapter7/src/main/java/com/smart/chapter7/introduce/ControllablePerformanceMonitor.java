package com.smart.chapter7.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * ControllablePerformanceMonitor
 *
 * @author ascend
 * @date 2017/11/2 10:13.
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();

    /**
     * 启动和关闭监控
     *
     * @param active boolean
     */
    @Override
    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    /**
     * 拦截方法
     *
     * @param mi MethodInvocation
     * @return Object
     * @throws Throwable Throwable
     */
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        // 4、对于支持性能监视可控代理，通过判断其状态决定是否开启性能监视功能
        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
