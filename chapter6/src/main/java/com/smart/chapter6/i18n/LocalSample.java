package com.smart.chapter6.i18n;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * LocalSample
 *
 * @author ascend
 * @date 2017/10/25 16:26
 */
public class LocalSample {
    @Test
    public void testNumberFormat() {
        Locale chinaLocal = new Locale("zh", "CN");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(chinaLocal);
        double amt = 123456.78000;
        System.out.println(currencyInstance.format(amt));
    }

    @Test
    public void testDateFormat() {
        Locale locale = new Locale("zh", "CN");
        Date date = new Date();
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, locale);
        System.out.println(dateInstance.format(date));
    }

    @Test
    public void testMessageFormat() {
        Object[] params = {"Bob", new GregorianCalendar().getTime(), 1.0E3};
        String pattern1 = "{0}，你好！你于{1}在工商银行存入{2} 元。";
        String pattern2 = "At {1,time,short} On{1,date,long}，{0} paid {2,number,currency}.";

        String msg1 = MessageFormat.format(pattern1, params);
        MessageFormat mf = new MessageFormat(pattern2, Locale.US);
        String msg2 = mf.format(params);
        System.out.println(msg1);
        System.out.println(msg2);
    }

    @Test
    public void testResourceBundle() {
        ResourceBundle bundle1 = ResourceBundle.getBundle("com/smart/chapter6/i18n/resource", Locale.US);
        ResourceBundle bundle2 = ResourceBundle.getBundle("com/smart/chapter6/i18n/resource", Locale.CHINA);
        System.out.println("us:" + bundle1.getString("greeting.common"));
        System.out.println("cn:" + bundle2.getString("greeting.common"));
    }

    @Test
    public void testResourceBundleFormat() {
        ResourceBundle bundle1 = ResourceBundle.getBundle("com/smart/chapter6/i18n/fmt_resource", Locale.US);
        ResourceBundle bundle2 = ResourceBundle.getBundle("com/smart/chapter6/i18n/fmt_resource", Locale.CHINA);
        Object[] params = {"Bob", new GregorianCalendar().getTime()};
        MessageFormat format = new MessageFormat(bundle1.getString("greeting.common"), Locale.US);
        System.out.println(format.format(params));
        format.applyPattern(bundle2.getString("greeting.morning"));
        format.setLocale(Locale.CHINA);
        System.out.println(format.format(params));
        format.applyPattern(bundle2.getString("greeting.afternoon"));
        System.out.println(format.format(params));
    }


}
