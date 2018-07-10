package com.smart.chapter19.oxm.xstream.converters;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * DateConverter
 *
 * @author ascend
 * @date 2018/7/10 11:33.
 */
public class DateConverter implements Converter{
    private Locale locale;

    public DateConverter(Locale locale) {
        super();
        this.locale = locale;
    }

    /**
     * 实现该方法，编写JAVA对象到XML转换逻辑
     * @param source Object
     * @param writer HierarchicalStreamWriter
     * @param context MarshallingContext context
     */
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, this.locale);
        writer.setValue(dateFormat.format(source));
    }

    /**
     * 实现该方法，编写XML到JAVA对象转换逻辑
     * @param reader HierarchicalStreamReader
     * @param context UnmarshallingContext
     * @return Object
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, this.locale);
        try {
            calendar.setTime(dateFormat.parse(reader.getValue()));
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(), e);
        }
        return calendar.getGregorianChange();
    }


    /**
     * 实现该方法，判断要转换的类型
     * @param type Class
     * @return boolean
     */
    @Override
    public boolean canConvert(Class type) {
        return Date.class.isAssignableFrom(type);
    }




    public static void main(String[] args) {
        System.out.println(DateConverter.class.isAssignableFrom(Converter.class));
        System.out.println(Converter.class.isAssignableFrom(DateConverter.class));
    }
}
