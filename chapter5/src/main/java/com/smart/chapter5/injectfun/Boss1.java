package com.smart.chapter5.injectfun;

public class Boss1 implements MagicBoss {

    public Car getCar() {
        Car car = new Car();
        car.setBrand("宝马Z4");
        return car;
    }
}
