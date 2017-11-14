package com.smart.chapter8.ltw;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * PreGreetingAspect
 *
 * @author ascend
 * @date 2017/11/14 11:28.
 */
@Aspect
public class PreGreetingAspect {
    @Before(value = "execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("How are you!");
    }
}
