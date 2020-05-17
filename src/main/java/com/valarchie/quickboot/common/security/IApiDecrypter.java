package com.valarchie.quickboot.common.security;

/**
 * @description: 项目中的接口解密类
 * @Author: valarchie
 * @Date: 2020-04-19 11:27
 */
public interface IApiDecrypter {

    /**
     * 解密加密串
     * @param encryptStr 加密后的字符串
     * @return
     */
    String decrypt(String encryptStr);


}
