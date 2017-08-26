package com.smart.chapter4.context;

import com.smart.chapter4.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

/**
 * Test
 * Created by zziaa on 2017/08/26.
 */
public class AnnotationApplicationContextTest {
    @Test
    public void getBean() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        car.introduce();
    }
}
