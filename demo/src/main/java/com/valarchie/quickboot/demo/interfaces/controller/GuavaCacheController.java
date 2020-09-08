package com.valarchie.quickboot.demo.interfaces.controller;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class GuavaCacheController {

    public static Cache memoryCache;

    static {

        memoryCache = CacheBuilder.newBuilder().initialCapacity(2 >> 10).
                expireAfterAccess(30, TimeUnit.DAYS).expireAfterAccess(30, TimeUnit.DAYS).initialCapacity(1024).build();

    }

}