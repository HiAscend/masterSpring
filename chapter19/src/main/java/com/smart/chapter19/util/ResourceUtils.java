package com.smart.chapter19.util;

/**
 * @author ascend
 */
public class ResourceUtils {
    /**
     * 获取当前类所在的物理路径
     *
     * @param cls  类
     * @param name 文件名
     * @return String
     */
    public static String getResourceFullPath(Class cls, String name) {
        String path = cls.getResource("").getPath();
        path = path.substring(1);
        return (path + name).replace("test-classes", "classes");
    }

}
