package com.smart.chapter4.resource;

import org.junit.Test;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Test
 * Created by zziaa on 2017/08/24.
 */
public class PatternResolverTest {
    @Test
    public void getResources() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    }
}
