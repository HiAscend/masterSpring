package com.smart.chapter19.oxm.xstream.persistence;

import com.smart.chapter19.domain.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PersistenceSample
 *
 * @author ascend
 * @date 2018/7/12 9:35.
 */
public class PersistenceSample {
    private static List<User> userList;

    private void persist() {
        userList = new ArrayList<>();
        User user = new User();
        user.setUserId(1);
        user.setCredits(10);
        user.setUserName("tom");
        user.setPassword("123456");
        userList.add(user);
        userList.add(user);
        File file = new File("chapter19/out");
        PersistenceStrategy strategy = new FilePersistenceStrategy(file);
        List list = new XmlArrayList(strategy);
        list.addAll(userList);
    }

    public static void main(String[] args) throws IOException {
       /* PersistenceSample sample = new PersistenceSample();
        sample.persist();*/

        /*XStream xstream = new XStream();
        xstream.registerConverter(new PersistenceArrayListConverter(xstream));
        String xml = xstream.toXML(userList);
        System.out.println(xml);*/

        /*XStream xStream = new XStream();
        xStream.registerConverter(new PersistenceArrayListConverter(xStream));
        InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(System.getProperty("user.home"), "documents/int@0.xml")));
        Object o = xStream.fromXML(reader);
        System.out.println("o = " + o);*/
        FileInputStream inputStream = new FileInputStream("chapter19/out/int@0.xml");
        User user = (User) new XStream().fromXML(inputStream);
        System.out.println("user = " + user);



        /*System.out.println(PersistenceSample.class.getResource("").getPath());
        System.out.println(PersistenceSample.class.getResource("/").getPath());
        System.out.println(new File("").getCanonicalPath());
        System.out.println(new File("/").getCanonicalPath());
        System.out.println(System.getProperty("user.dir"));*/
    }

    @Test
    public void test1() throws FileNotFoundException{
        FileInputStream inputStream = new FileInputStream("chapter19/out/int@0.xml");
        User user = (User) new XStream().fromXML(inputStream);
        System.out.println("user = " + user);
    }

    @Test
    public void test2() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(new File("").getCanonicalPath(), "out/int@0.xml"));
        User user = (User) new XStream().fromXML(inputStream);
        System.out.println("user = " + user);
    }

}

