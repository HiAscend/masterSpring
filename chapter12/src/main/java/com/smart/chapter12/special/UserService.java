package com.smart.chapter12.special;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author ascend
 * @date 2017/11/17 15:49.
 */
@Service
public class UserService implements UserServiceInterface {
    /**
     * private 方法因访问权限的限制，无法被子类覆盖
     */
    private void method1() {
        System.out.println("UserService.method1");
    }

    /**
     * final方法无法被子类覆盖
     */
    public final void method2() {
        System.out.println("UserService.method2");
    }

    /**
     * static方法是类级别的，无法被子类覆盖
     */
    public static void method3() {
        System.out.println("UserService.method3");
    }

    /**
     * 可以被子类覆盖，因此可以被动态字节码增强
     */
    @Override
    public void method4() {
        System.out.println("UserService.method4");
    }

    /**
     * final方法不能被子类覆盖
     */
    @Override
    public final void method5() {
        System.out.println("UserService.method5");
    }

    /**
     * protected方法可以被子类覆盖，因此可以被动态字节码增强
     */
    protected void method6() {
        System.out.println("UserService.method6");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/smart/chapter12/special/applicationContext.xml");
        UserService service = context.getBean("userService", UserService.class);

        System.out.println("before method1");
        service.method1();
        System.out.println("after method1");

        System.out.println("before method2");
        service.method2();
        System.out.println("after method2");

        System.out.println("before method3");
        UserService.method3();
        System.out.println("after method3");

        System.out.println("before method4");
        service.method4();
        System.out.println("after method4");

        System.out.println("before method5");
        service.method5();
        System.out.println("after method5");

        System.out.println("before method6");
        service.method6();
        System.out.println("after method6");


    }
}
