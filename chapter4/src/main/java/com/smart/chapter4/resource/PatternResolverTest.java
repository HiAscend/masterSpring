package com.smart.chapter4.resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * Test
 * Created by zziaa on 2017/08/24.
 */
public class PatternResolverTest {
    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //加载所有类包com.smart(及子孙包)下.xml为后缀的资源
        Resource[] resources = resolver.getResources("classpath*:com/smart/**/*.xml");
        Assert.assertNotNull(resources);
        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}
