package com.valarchie.quickboot.common.log;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.valarchie.quickboot.common.security.IApiEncrypter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * description: 控制器日志模块
 *
 * @author: valarchie
 * on: 2020/4/22
 * @email: 343928303@qq.com
 */
@ControllerAdvice(basePackages = "com.valarchie")
@Slf4j
public class ControllerLogAdvice implements RequestBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter,
                                           Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {

        System.out.println("1111");

        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter,
                                Type type, Class<? extends HttpMessageConverter<?>> aClass) {

        System.out.println("1111");

        log.info("parameters is {}" + o);
        return o;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter,
                                  Type type, Class<? extends HttpMessageConverter<?>> aClass) {


        System.out.println("1111");
        log.info("parameters is {}" + o);

        return o;
    }
}