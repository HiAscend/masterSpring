package com.smart.chapter19.oxm.xstream.alias;

import com.smart.chapter19.domain.LoginLog;
import com.smart.chapter19.domain.User;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * XStreamAliasSample
 *
 * @author ascend
 * @date 2018/7/10 10:29.
 */
public class XStreamAliasSample {
    private static XStream xStream;
    static {
        xStream = new XStream();
        // 设置类别名，默认类的全限定名
        xStream.alias("loginLog", LoginLog.class);
        xStream.alias("user", User.class);
        // 设置类成员别名
        xStream.aliasField("id", User.class, "userId");
        //把 LoginLog的userId属性视为 XML属性,默认为XML的元素
        xStream.aliasAttribute(LoginLog.class, "userId", "id");
        xStream.useAttributeFor(LoginLog.class, "userId");
        //去掉集合类型生成xml的父节点,即忽略 XML中的 <logs></logs>标记
        xStream.addImplicitCollection(User.class, "logs");
    }

    // 初始化转换对象

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
     * java对象转化为xml
     *
     * @throws FileNotFoundException FileNotFoundException
     */
    private static void objectToXml() throws FileNotFoundException {
        User user = getUser();
        FileOutputStream fileOutputStream = new FileOutputStream("chapter19/out/XStreamAliasSample-User.xml");
        xStream.toXML(user, fileOutputStream);
    }

    /**
     * xml转化为java对象
     * @return User
     * @throws FileNotFoundException FileNotFoundException
     */
    private static User xmlToObject() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("chapter19/out/XStreamAliasSample-User.xml");
        return (User) xStream.fromXML(fileInputStream);
    }

    public static void main(String[] args) throws FileNotFoundException {
        objectToXml();
        User user = xmlToObject();
        System.out.println("user = " + user);
    }

}
