package com.smart.chapter17.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * GroovyTest
 *
 * @author ascend
 * @date 2018/4/9 14:22.
 */
public class GroovyTest {
    @Test
    public void test() throws ResourceException, ScriptException, IOException, InterruptedException {
        String[] paths = {"E:\\adeng\\maven\\masterSpring\\chapter17\\src\\main\\java\\com\\smart\\chapter17\\groovy"};
        GroovyScriptEngine gse = new GroovyScriptEngine(paths);
        Binding binding = new Binding();
        Object[] args = {"variable1", "variable2"};
        binding.setVariable("args", args);
        binding.setVariable("userName", "tom");

        String result = (String) gse.run("HelloGroovy.groovy", binding);
        System.out.println("result = " + result);
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testGroovyClassLoader() throws IllegalAccessException, InstantiationException, IOException {
        try(GroovyClassLoader loader = new GroovyClassLoader()) {

            Class groovyClass = loader.parseClass(new File("E:\\adeng\\maven\\masterSpring\\chapter17\\src\\main\\java\\com\\smart\\chapter17\\groovy\\HelloGroovy.groovy"));
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            Object result = groovyObject.invokeMethod("sayHello", "katherine");
            System.out.println("result:"+result.toString());
            loader.clearCache();
        }

    }
}
