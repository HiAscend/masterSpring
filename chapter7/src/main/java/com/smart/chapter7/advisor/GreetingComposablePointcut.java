package com.smart.chapter7.advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * GreetingComposablePointcut
 *
 * @author ascend
 * @date 2017/11/6 17:37.
 */
public class GreetingComposablePointcut {

    public Pointcut getIntersectionPointcut() {
        // 创建一个复合切点
        ComposablePointcut composablePointcut = new ComposablePointcut();
        // 创建一个流程切点
        Pointcut pointcut1 = new ControlFlowPointcut(WaiterDelegate.class, "service");
        // 创建一个方法名切点
        NameMatchMethodPointcut pointcut2 = new NameMatchMethodPointcut();
        pointcut2.addMethodName("greetTo");
        return composablePointcut.intersection(pointcut1).intersection((Pointcut) pointcut2);

    }
}
