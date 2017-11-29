package com.smart.chapter15.cache.mycache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CacheManager
 *
 * @author ascend
 * @date 2017/11/29 21:56
 */
public class CacheManager<T> {
    private Map<String, T> cache = new ConcurrentHashMap<>();

    public T getValue(String key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key, value);
    }

    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    public void evictCache() {
        cache.clear();
    }
}
