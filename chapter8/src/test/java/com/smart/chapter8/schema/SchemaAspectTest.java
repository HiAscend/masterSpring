package com.smart.chapter8.schema;

import com.smart.chapter8.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * SchemaAspectTest
 *
 * @author ascend
 * @date 2017/11/10 10:37.
 */
public class SchemaAspectTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter8/schema/beans.xml");
        Waiter naiveWaiter = context.getBean("naiveWaiter", Waiter.class);
        Waiter naughtyWaiter = context.getBean("naughtyWaiter", NaughtyWaiter.class);
        Seller seller = context.getBean("seller", SmartSeller.class);

//        naiveWaiter.greetTo("John");

//        Final增强
//        naughtyWaiter.greetTo("Tom");

//        后置增强
//        seller.sell("Beer", "katherine");

//        环绕增强
//        naiveWaiter.serveTo("katherine");

//        抛出异常增强
//        ((SmartSeller)seller).checkBill(1);

//        引介增强
//        ((Seller) naiveWaiter).sell("Beer", "katherine");

//        参数绑定
//        ((NaiveWaiter) naiveWaiter).smile("katherine", 2);
//        ((NaiveWaiter) naiveWaiter).smile2( 2, "katherine");

//        advisor
        naiveWaiter.greetTo("katherine");
    }


}
