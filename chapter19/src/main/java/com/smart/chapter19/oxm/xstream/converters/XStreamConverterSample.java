package com.smart.chapter19.oxm.xstream.converters;

import com.smart.chapter19.domain.LoginLog;
import com.smart.chapter19.domain.User;
import com.smart.chapter19.util.ResourceUtils;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

/**
 * XStreamConverterSample
 *
 * @author ascend
 * @date 2018/7/10 14:15.
 */
public class XStreamConverterSample {
    public static String FILE_NAME = "";
    private static XStream xStream;
    private static User user;
    static{
        xStream = new XStream();

        xStream.alias("loginLog", LoginLog.class);
        xStream.alias("user", User.class);

        // 下面两行效果相同
        // xStream.aliasField("id",User.class,"userId");
        xStream.aliasAttribute(User.class, "userId", "id");

        xStream.useAttributeFor(User.class, "userId");
        xStream.addImplicitCollection(User.class, "logs");
        xStream.registerConverter(new DateConverter(Locale.SIMPLIFIED_CHINESE));
    }

    /**
     * 初始化用户
     */
    private static void initUser() {
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.0.141");
        log1.setLoginDate(new Date());
        LoginLog log2 = new LoginLog();
        log2.setIp("192.168.0.142");
        log2.setLoginDate(new Date());
        user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);
        user.addLoginLog(log2);
    }

    /**
     * java对象转化为xml
     *
     * @throws FileNotFoundException FileNotFoundException
     */
    private static void objectToXml() throws FileNotFoundException {
        initUser();
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8"));
        xStream.toXML(user, writer);
    }

    /**
     * xml转化为java对象
     * @return User
     * @throws FileNotFoundException FileNotFoundException
     */
    private static User xmlToObject() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader reader = new InputStreamReader(fis, Charset.forName("UTF-8"));
        return  (User) xStream.fromXML(reader);
    }

    public static void main(String[] args) throws FileNotFoundException {
        FILE_NAME = ResourceUtils.getResourceFullPath(XStreamConverterSample.class, "XStreamConverterSample.xml");
        objectToXml();
        User user = xmlToObject();
        System.out.println("user = " + user);
    }
}
