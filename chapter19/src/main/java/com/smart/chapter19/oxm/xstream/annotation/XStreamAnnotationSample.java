package com.smart.chapter19.oxm.xstream.annotation;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * XStreamAnnotationSample
 *
 * @author ascend
 * @date 2018/7/11 14:38.
 */
public class XStreamAnnotationSample {
    private static XStream xStream;

    static {
        xStream = new XStream();
        // xStream.processAnnotations(User.class);
        // xStream.processAnnotations(LoginLog.class);
        xStream.autodetectAnnotations(true);
    }

    @SuppressWarnings("Duplicates")
    private static User getUser() {
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.0.141");
        log1.setLoginDate(new Date());
        LoginLog log2 = new LoginLog();
        log2.setIp("192.168.0.142");
        log2.setLoginDate(new Date());
        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);
        user.addLoginLog(log2);
        return user;
    }

    /**
     * java obj to xml
     * @throws FileNotFoundException FileNotFoundException
     */
    private static void objectToXml() throws FileNotFoundException {
        User user = getUser();
        FileOutputStream outputStream = new FileOutputStream("chapter19/out/XStreamAnnotationSample.xml");
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, Charset.forName("UTF-8"));
        xStream.toXML(user, writer);
    }

    /**
     * covnert xml to java object
     * @return User
     * @throws FileNotFoundException FileNotFoundException
     */
    private static User xmlToObject() throws FileNotFoundException{
        FileInputStream inputStream = new FileInputStream("chapter19/out/XStreamAnnotationSample.xml");
        InputStreamReader reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        return (User) xStream.fromXML(reader);
    }

    public static void main(String[] args) throws FileNotFoundException{
        // objectToXml();
        User us = xmlToObject();
        System.out.println("us = " + us);

    }
}
