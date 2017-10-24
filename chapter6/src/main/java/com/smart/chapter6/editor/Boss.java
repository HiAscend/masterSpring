package com.smart.chapter6.editor;

/**
 * Boss
 *
 * @author ascend
 * @date 2017/10/24 11:37
 */
public class Boss {
    private String name;

    private Car car = new Car();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
