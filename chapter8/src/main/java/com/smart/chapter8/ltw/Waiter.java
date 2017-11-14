package com.smart.chapter8.ltw;

/**
 * Waiter
 *
 * @author ascend
 * @date 2017/11/14 11:29.
 */
public class Waiter {
    public void greetTo(String clientName) {
        System.out.println("Waiter.greetTo:" + clientName);
    }

    public void serveTo(String clientName) {
        System.out.println("Waiter.serveTo:" + clientName);
    }
}
