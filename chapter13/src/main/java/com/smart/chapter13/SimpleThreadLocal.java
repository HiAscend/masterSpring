package com.smart.chapter13;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * SimpleThreadLocal
 *
 * @author ascend
 * @date 2017/11/15 12:58.
 */
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        // 键为线程对象，值为线程的变量副本
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get() {
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if (o == null && !valueMap.containsKey(currentThread)) {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove() {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue() {
        return null;
    }

}
