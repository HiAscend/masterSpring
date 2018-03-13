package com.smart.chapter17;

import org.springframework.core.io.ClassPathResource;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * com.smart.chapter17.Client
 *
 * @author ascend
 * @date 2018/3/12 17:22.
 */
public class Client {
    public static void main(String[] args) {

    }

    @Test
    public void test() throws IOException, URISyntaxException {
        File file = new File(Client.class.getClassLoader().getResource("com/smart/chapter17/test.txt").toURI());
        System.out.println(file.getName());
//        ClassPathResource resource = new ClassPathResource("com/smart/chapter17/test.txt");
//        File testFile = resource.getFile();
//        System.out.println("testFile.getName() = " + testFile.getName());
    }
}
