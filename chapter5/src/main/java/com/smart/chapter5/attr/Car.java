package com.smart.chapter5.attr;

/**
 * Car
 * Created by ascend on 2017/9/29 16:17.
 */
public class Car {
    private String brand;
    private int maxSpeed;
    private double price;
    public static  String  HONG_QI = "红旗";

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
