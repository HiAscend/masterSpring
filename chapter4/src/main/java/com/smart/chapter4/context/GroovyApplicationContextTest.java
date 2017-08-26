package com.smart.chapter4.context;

import com.smart.chapter4.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test
 * Created by zziaa on 2017/08/26.
 */
public class GroovyApplicationContextTest {
    @Test
    public void getBean() {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:com/smart/context/groovy-beans.groovy");
        Car car = ctx.getBean("car", Car.class);
        Assert.assertNotNull(car);
        Assert.assertEquals(car.getColor(), "red");
    }
}
