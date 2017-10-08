package com.smart.chapter5.anno;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * MyComponent
 * Created by zziaa on 2017/10/08.
 */
public class MyComponent {
    // Spring会将容器中所有类型为plugin的Bean注入到这个变量中
    @Autowired
    private List<Plugin> plugins;

    // 将Plugin类型的Bean注入Map中
    private Map<String, Plugin> pluginMap;

    public List<Plugin> getPlugins() {
        return plugins;
    }
}
