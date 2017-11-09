package com.smart.chapter8;

/**
 * SmartSeller
 *
 * @author ascend
 * @date 2017/11/9 14:05.
 */
public class SmartSeller implements Seller {
    @Override
    public int sell(String goods, String clientName) {
        System.out.println("SmartSeller.sell:" + goods + " to " + clientName + "...");
        return 100;
    }

    public void checkBill(int billId) {
        if (billId ==1 ){
            throw new IllegalArgumentException("illegalArgumentException");
        } else {
            throw new RuntimeException("RuntimeException");
        }
    }
}
