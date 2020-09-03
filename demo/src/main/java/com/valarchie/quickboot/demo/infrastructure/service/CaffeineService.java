package com.valarchie.quickboot.demo.infrastructure.service;

/**
* description: 本地缓存示例
* @author: valarchie
* on: 2020/5/19
* @email: 343928303@qq.com
*/
public interface CaffeineService {

    /**
     * 获取用户
     * @param key
     * @return
     */
    String getUser(String key);

    /**
     * 添加用户
     * @param key
     * @param user
     * @return
     */
    String putUser(String key, String user);

    /**
     * 清楚用户
     * @param key
     * @return
     */
    String cleanUser(String key);


}
