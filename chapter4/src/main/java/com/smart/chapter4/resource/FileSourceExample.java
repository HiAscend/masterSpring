package com.smart.chapter4.resource;

import org.springframework.core.io.*;
import org.springframework.web.context.support.ServletContextResource;
import org.testng.annotations.Test;

import java.io.*;


public class FileSourceExample {
    private String filePath = "D:\\tool\\myOwnWorkspace\\masterSpring\\chapter4\\src\\main\\resources\\conf\\file1.txt";

    @Test
    public void testFileSystemResource() throws IOException {
        FileSystemResource fsr = new FileSystemResource(filePath);
        System.out.println("fsr.getFilename() = " + fsr.getFilename());
        InputStream is = fsr.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        byte[] arr = new byte[1024];
        while (is.read(arr) != -1) {
            stringBuilder.append(new java.lang.String(arr, 0, arr.length));
        }
        System.out.println(stringBuilder.toString());
        is.close();
    }

    @Test
    public void testFileSystemResource2() throws IOException {
        FileSystemResource fsr = new FileSystemResource(filePath);
        System.out.println("fsr.getFilename() = " + fsr.getFilename());
        InputStream is = fsr.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        System.out.println(baos.toString("UTF-8"));
        is.close();
        baos.close();
    }

    @Test
    public void testPathResource() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableResource pathResource = new PathResource(filePath);
        InputStream inputStream = pathResource.getInputStream();
        int i;
        while ((i = inputStream.read()) != -1) {
            baos.write(i);
        }
        System.out.println(baos.toString());
        inputStream.close();
        baos.close();
    }

    @Test
    public void testClassPathResource() throws IOException {
        Resource resource = new ClassPathResource("conf/file1.txt");
        InputStream is = resource.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        byte[] arr = new byte[1024];
        while (is.read(arr) != -1) {
            stringBuilder.append(new java.lang.String(arr, 0, arr.length));
        }
        System.out.println(stringBuilder.toString());
        is.close();
    }

    @Test
    public void testWritableResource() throws IOException {
        WritableResource resource = new PathResource(filePath);
        OutputStream outputStream = resource.getOutputStream();
        outputStream.write("hello world".getBytes());
        outputStream.close();
    }

    @Test
    public void testResource() throws IOException {
        Resource resource = new ClassPathResource("conf/file1.txt");
        Resource resourceRelative = resource.createRelative("file2.txt");
        System.out.println(resourceRelative.getFile().getName());
    }

    @Test
    public void testServletContextResource() {
//        new ServletContextResource()
    }

    public static void main(String[] args) {

    }


}
