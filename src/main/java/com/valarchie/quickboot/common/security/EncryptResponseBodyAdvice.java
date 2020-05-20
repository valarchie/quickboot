package com.valarchie.quickboot.common.security;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
* description: 返回结果加密处理
* @author: valarchie
* on: 2020/4/22
* @email: 343928303@qq.com
*/
@ControllerAdvice(basePackages = "com.valarchie.quickboot.controller")
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        System.out.println("ssss");

        return null;
    }
}