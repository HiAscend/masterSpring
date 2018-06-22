package com.smart.chapter18.util;

import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * MyToStringStyleSingleton
 * 对象转化为字符串
 *
 * @author ascend
 * @date 2018/6/12 9:32.
 */
public class MyToStringStyleSingleton extends StandardToStringStyle {

    private static final long serialVersionUID = -948804986298931968L;
    private static final MyToStringStyleSingleton INSTANCE = new MyToStringStyleSingleton();

    /**
     * DateTimeFormatter
     */
    private transient DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private MyToStringStyleSingleton() {
    }

    /**
     * 饿汉模式
     *
     * @return ToStringStyle
     */
    public static ToStringStyle getInstance() {
        return INSTANCE;
    }

    /**
     * <p>Append to the <code>toString</code> an <code>Object</code>
     * value, printing the full detail of the <code>Object</code>.</p>
     *
     * @param buffer    the <code>StringBuffer</code> to populate
     * @param fieldName the field name, typically not used as already appended
     * @param value     the value to add to the <code>toString</code>,
     */
    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        // gmtCreate gmtModified Date
        /*String gmtCreate = "gmtCreate";
        String gmtModified = "gmtModified";
        boolean shouldFormat = (value instanceof Date) && (gmtCreate.equals(fieldName) || gmtModified.equals(fieldName));
        if (shouldFormat) {
            value = DateFormatUtils.format((Date) value, "yyyy-MM-dd HH:mm:ss");
        }*/

        // localDateTime
        /*if (value instanceof LocalDateTime) {
            value = ((LocalDateTime) value).format(dateTimeFormatter);
        }*/

        // Date
        if (value instanceof Date) {
            value = DateFormatUtils.format((Date)value, "yyyy-MM-dd HH:mm:ss");
        }
        buffer.append(value);
    }
}
