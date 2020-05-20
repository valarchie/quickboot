package com.valarchie.quickboot.common.security;

/**
* Created by
* @author: valarchie
* on: 2020/4/21
* @email: 343928303@qq.com
*/
public interface IApiDecrypter {

    /**
     * 解密
     * @param parameter 加密参数
     * @return 解密后的参数
     */
    String decryptParameter(String parameter);


}
