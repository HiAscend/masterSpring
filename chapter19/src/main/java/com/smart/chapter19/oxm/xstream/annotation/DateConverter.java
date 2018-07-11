package com.smart.chapter19.oxm.xstream.annotation;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateConverter
 *
 * @author ascend
 * @date 2018/7/11 14:32.
 */
public class DateConverter implements SingleValueConverter {

    public DateConverter() {
    }

    @Override
    public String toString(Object obj) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //
            dateFormat.setLenient(true);
            return dateFormat.format((Date) obj);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object fromString(String str) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //
            dateFormat.setLenient(true);
            return dateFormat.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }
}
