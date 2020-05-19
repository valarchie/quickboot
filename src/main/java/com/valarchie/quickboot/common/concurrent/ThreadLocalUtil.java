package com.valarchie.quickboot.common.concurrent;

import java.util.*;

/**
* description: threadLocal工具类
* @author: valarchie
* on: 2020/5/19
* @email: 343928303@qq.com
*/
public final class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL_MAP =
            ThreadLocal.withInitial(() -> new HashMap());

    public static Map<String, Object> getThreadLocal() {
        return THREAD_LOCAL_MAP.get();
    }

    public static <T> T get(String key) {
        Map map = THREAD_LOCAL_MAP.get();
        return (T) map.get(key);
    }

    public static <T> T get(String key, T defaultValue) {
        Map map = THREAD_LOCAL_MAP.get();
        return (T) map.get(key) == null ? defaultValue : (T) map.get(key);
    }

    public static void set(String key, Object value) {
        Map map = THREAD_LOCAL_MAP.get();
        map.put(key, value);
    }

    public static void remove() {
        THREAD_LOCAL_MAP.remove();
    }

    public static <T> T remove(String key) {
        Map map = (Map) THREAD_LOCAL_MAP.get();
        return (T) map.remove(key);
    }




}