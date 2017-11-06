package com.smart.chapter7.advisor;

/**
 * WaiterDelegate
 *
 * @author ascend
 * @date 2017/11/6 16:43.
 */
public class WaiterDelegate {
    private Waiter waiter;

    /**
     * waiter 的方法通过该方法发起调用
     * @param clientName String
     */
    public void service(String clientName) {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
