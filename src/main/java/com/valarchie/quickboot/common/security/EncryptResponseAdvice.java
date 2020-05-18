package com.valarchie.quickboot.common.security;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
* description: 返回结果加密处理
* @author: valarchie
* on: 2020/4/22
* @email: 343928303@qq.com
*/
//@ControllerAdvice(basePackages = "com.valarchie")
@Slf4j
public class EncryptResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.hasMethodAnnotation(ResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (mediaType == MediaType.APPLICATION_JSON) {

            log.debug("start encrypt responsebody, origin data:{}", o);
            // 定义加密器
            IApiEncrypter encrypter = data -> Base64.encode(JSON.toJSONString(data));

            String encode = encrypter.encryptData(o);

            return encode;

        } else {

            log.debug("responsebody without encrypt, origin data:{}", o);

            return o;
        }


    }


}