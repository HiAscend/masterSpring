package com.smart.chapter8;

import com.smart.chapter8.anno.NeedTest;

/**
 * NaughtyWaiter
 *
 * @author ascend
 * @date 2017/11/9 14:24.
 */
public class NaughtyWaiter implements Waiter {
    @NeedTest
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter.greetTo:" + clientName);
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiter.serveTo:" + clientName);
    }

    public void joke(String clientName, int times) {
        System.out.println("NaughtyWaiter.joke to:" + clientName + " " + times);
    }
}
