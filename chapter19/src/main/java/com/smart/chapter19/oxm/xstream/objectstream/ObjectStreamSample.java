package com.smart.chapter19.oxm.xstream.objectstream;

import com.smart.chapter19.domain.LoginLog;
import com.smart.chapter19.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

import java.io.*;
import java.util.Date;

/**
 * ObjectStreamSample
 *
 * @author ascend
 * @date 2018/7/11 14:59.
 */
public class ObjectStreamSample {
    private static XStream xStream;

    static {
        xStream = new XStream();
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
     * convert java object to xml
     *
     * @throws IOException IOException
     */
    private static void objectToXml() throws IOException {
        User user = getUser();
        PrintWriter printWriter = new PrintWriter("chapter19/out/ObjectStreamSample.xml");
        PrettyPrintWriter prettyPrintWriter = new PrettyPrintWriter(printWriter);
        try (ObjectOutputStream outputStream = xStream.createObjectOutputStream(prettyPrintWriter)) {
            outputStream.writeObject(user);
        }
    }

    /**
     * convert xml to java object
     *
     * @return User
     */
    private static User xmlToObject() throws IOException, ClassNotFoundException {
        // 1.我们需要通过对象流进行输入操作，需要FileReader和BufferedReader
        FileReader fileReader = new FileReader("chapter19/out/ObjectStreamSample.xml");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // 创建对象输入流
        try (ObjectInputStream input = xStream.createObjectInputStream(bufferedReader)) {
            return (User) input.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // objectToXml();
        System.out.println(xmlToObject());
    }


}
