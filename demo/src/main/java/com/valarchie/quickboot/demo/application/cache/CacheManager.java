package com.valarchie.quickboot.demo.application.cache;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.catalina.User;

import java.util.concurrent.TimeUnit;

/**
* description: 用户缓存
* @author: valarchie
* @date 2020/9/8
* @email: 343928303@qq.com
*/
public class CacheManager {


    /**
     * 用户缓存
     */
    public static Cache<String, User> userCache;

    public static Cache tokenCache;

    static {

        userCache = CacheBuilder.newBuilder().initialCapacity(2 >> 10).
                expireAfterAccess(30, TimeUnit.DAYS).expireAfterAccess(30, TimeUnit.DAYS).initialCapacity(1024).build();



        tokenCache = CacheBuilder.newBuilder().initialCapacity(2 >> 10).
                expireAfterAccess(30, TimeUnit.DAYS).expireAfterAccess(30, TimeUnit.DAYS).initialCapacity(1024).build();
    }



}