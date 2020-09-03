package com.valarchie.quickboot.core.common.security;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
@ConditionalOnProperty(value = "project.security.encrypt-response")
@ControllerAdvice(basePackages = "com.valarchie")
@Slf4j
public class EncryptResponseAdvice implements ResponseBodyAdvice {

    {
        log.info("{} is register success!", this.getClass().getSimpleName());
    }



    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.hasMethodAnnotation(ResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (mediaType == MediaType.APPLICATION_JSON) {

            log.debug("start encrypt response body, origin data:{}", o);
            // 定义加密器
            IApiEncrypter encryptors = data -> Base64.encode(JSON.toJSONString(data));

            return encryptors.encryptData(o);

        } else {

            log.debug("response body without encrypt");

            return o;
        }


    }


}