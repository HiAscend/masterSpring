package com.smart.chapter18.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * MyReflectionToStringBuilder
 *
 * @author ascend
 * @date 2018/6/8 8:50.
 */
public class MyReflectionToStringBuilder {

    public MyReflectionToStringBuilder() {
    }

    /**
     * 自定义的对象转换字符串
     * 日期输出：gmtCreate||gmtModified-->yyyy-MM-dd HH:mm:ss
     * LocalDateTime-->yyyy-MM-dd HH:mm:ss
     *
     * @param object Object
     * @return String
     */
    public static String toString(Object object) {
        // 日期输出：gmtCreate||gmtModified-->yyyy-MM-dd HH:mm:ss
        return ReflectionToStringBuilder.toString(object, MyToStringStyleSingleton.getInstance());
    }

}
