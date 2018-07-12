package com.smart.chapter19.oxm.xstream.json;

import com.smart.chapter19.domain.LoginLog;
import com.smart.chapter19.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * XStreamJSONSample
 *
 * @author ascend
 * @date 2018/7/12 14:45.
 */
public class XStreamJSONSample {
    private static XStream xstream;



    private static User getUser() {
        LoginLog log1 = new LoginLog();
        log1.setIp("192.168.1.91");
        log1.setLoginDate(new Date());
        LoginLog log2 = new LoginLog();
        log2.setIp("192.168.1.92");
        log2.setLoginDate(new Date());
        User user = new User();
        user.setUserId(1);
        user.setUserName("xstream");
        user.addLoginLog(log1);
        user.addLoginLog(log2);
        return user;
    }

    public static void toJsonByJettisonMappedXmlDriver()throws FileNotFoundException {
        User user = getUser();
        FileOutputStream outputSteam = new FileOutputStream("chapter19/out/JettisonMappedSample.json");
        OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));
        JettisonMappedXmlDriver streamDriver = new JettisonMappedXmlDriver();
        xstream = new XStream(streamDriver);
        // xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("user", User.class);
        xstream.toXML(user,writer);
    }

    public static void toJsonByJsonHierarchicalStreamDriver()throws FileNotFoundException {
        User user = getUser();
        FileOutputStream outputSteam = new FileOutputStream("chapter19/out/JsonByJsonHierarchicalSample.json");
        OutputStreamWriter writer = new OutputStreamWriter(outputSteam, Charset.forName("UTF-8"));
        xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.alias("user", User.class);
        xstream.toXML(user,writer);
    }

    public static void main(String[] args) throws Exception {
        toJsonByJettisonMappedXmlDriver();
        toJsonByJsonHierarchicalStreamDriver();
    }
}
