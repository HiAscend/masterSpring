package com.smart.chapter19.oxm.xstream;

import com.smart.chapter19.domain.LoginLog;
import com.smart.chapter19.domain.User;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * XStreamSample
 *
 * @author ascend
 * @date 2018/7/10 9:29.
 */
public class XStreamSample {
    private static XStream xStream;

    static {
        xStream = new XStream();
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
        FileOutputStream fileOutputStream = new FileOutputStream("chapter19/out/XStreamSample-User.xml");
        xStream.toXML(user, fileOutputStream);
    }

    /**
     * xml转化为java对象
     * @return User
     * @throws FileNotFoundException FileNotFoundException
     */
    private static User xmlToObject() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("chapter19/out/XStreamSample-User.xml");
        return (User) xStream.fromXML(fileInputStream);
    }

    public static void main(String[] args) throws FileNotFoundException {
        objectToXml();
        User user = xmlToObject();
        System.out.println("user = " + user);
    }

}
