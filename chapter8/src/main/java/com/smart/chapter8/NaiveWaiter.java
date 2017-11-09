package com.smart.chapter8;

import com.smart.chapter8.anno.NeedTest;

/**
 * NaiveWaiter
 *
 * @author ascend
 * @date 2017/11/9 11:04.
 */
@Monitorable
public class NaiveWaiter implements Waiter {
    @NeedTest
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter.greetTo:" + clientName);
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaiveWaiter.serveTo:" + clientName);
    }

    public void smile(String clientName, int times) {
        System.out.println("NaiveWaiter.smile:" + clientName + " " + times + " times...");
    }
}
