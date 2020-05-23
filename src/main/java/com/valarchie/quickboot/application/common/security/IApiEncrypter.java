package com.valarchie.quickboot.application.common.security;

/**
* description: api加密器
* @author: valarchie
* on: 2020/5/12
* @email: 343928303@qq.com
*/
public interface IApiEncrypter {

    /**
     * 自定义加密器
     * @param o
     * @return
     */
    String encryptData(Object o);

}