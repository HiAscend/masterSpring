package com.smart.chapter7.advice;

/**
 * NaiveWaiter
 *
 * @author ascend
 * @date 2017/10/31 11:37
 */
public class NaiveWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name + "...");
    }
}
