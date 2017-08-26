package com.smart.chapter4.context;

import com.smart.chapter4.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解方式注入Bean
 * Created by zziaa on 2017/08/26.
 */
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        car.setMaxSpeed(200);
        return car;
    }

}
