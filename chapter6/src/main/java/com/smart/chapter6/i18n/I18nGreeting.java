package com.smart.chapter6.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * I18nGreeting
 *
 * @author ascend
 * @date 2017/10/25 16:21
 */
public class I18nGreeting {
    @Test
    public void resourceBundleMessageSource() {
        String[] configs = {"com/smart/chapter6/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        // 1、获取MessageSource的Bean
        MessageSource messageSource = ctx.getBean("myResource", MessageSource.class);
        Object[] params = {"Bob", new GregorianCalendar().getTime()};

        // 2、获取格式化的国际化信息
        String str1 = messageSource.getMessage("greeting.common", params, Locale.US);
        String str2 = messageSource.getMessage("greeting.morning", params, Locale.CHINA);
        String str3 = messageSource.getMessage("greeting.afternoon", params, Locale.CHINA);
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);
    }

    @Test
    public void reloadableResourceBundleMessageSource() throws InterruptedException {
        String[] configs = {"com/smart/chapter6/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        // 1、获取MessageSource的Bean
        MessageSource messageSource = ctx.getBean("reloadableResourceBundleMessage", MessageSource.class);
        Object[] params = {"Bob", new GregorianCalendar().getTime()};

        // 2、获取格式化的国际化信息
        for (int i = 0; i < 2; i++) {
            String str1 = messageSource.getMessage("greeting.common", params, Locale.US);
            System.out.println("str1 = " + str1);
            TimeUnit.SECONDS.sleep(20);
        }
    }
}
