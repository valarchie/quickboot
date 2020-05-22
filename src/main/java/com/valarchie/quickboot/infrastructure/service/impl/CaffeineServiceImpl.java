package com.valarchie.quickboot.infrastructure.service.impl;

import com.valarchie.quickboot.infrastructure.service.CaffeineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
* description: 本地缓存
* @author: valarchie
* on: 2020/5/19
* @email: 343928303@qq.com
*/
@Slf4j
public class CaffeineServiceImpl implements CaffeineService {


    @Override
    @Cacheable(value = "user", key = "#key")
    public String getUser(String key) {

        log.info("getUser()方法执行");

        String user = loadData(key);

        return user;

    }

    @Override
    @CachePut(value = "user", key = "#key")
    public String putUser(String key, String user) {

        log.info("putUser()方法执行");

        return key;

    }


    @Override
    @CacheEvict(value = "user", key="#key")
    public String cleanUser(String key) {

        return key;
    }

    /**
     * 模拟查询操作 3s
     * @param key
     * @return
     */
    private String loadData(String key) {

        try {
            log.info("loadData()方法执行");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return key;
    }


}