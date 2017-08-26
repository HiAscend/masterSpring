package com.smart.context

import com.smart.chapter4.reflect.Car

/**
 * bean
 * Created by zziaa on 2017/08/26.
 */

beans {
    car(Car) {
        brand = "红旗"
        maxSpeed = 200
        color = "red"
    }
}
