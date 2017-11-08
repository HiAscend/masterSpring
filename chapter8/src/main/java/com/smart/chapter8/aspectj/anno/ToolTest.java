package com.smart.chapter8.aspectj.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * ToolTest
 *
 * @author ascend
 * @date 2017/11/8 17:48.
 */
public class ToolTest {
    @Test
    public void test() {
        // 2、得到ForumService对应的class对象
        Class clazz = ForumService.class;
        // 2、得到ForumService对应的Method数组
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            // 3、获取方法上所标注的注解对象
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (needTest != null) {
                if (needTest.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
