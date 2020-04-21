package com.valarchie.quickboot.common.security;

import cn.hutool.core.util.StrUtil;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
* description: api请求数据封装类
* @author: valarchie
* on: 2020/4/21
* @email: 343928303@qq.com
*/
@Data
@Slf4j
public class ApiRequest {

    private Long timeStamp;

    private ApiParameter data;

    private String sign;

    public ApiRequest(Long timeStamp, ApiParameter data, String sign) {

        if (timeStamp == null || data == null || StrUtil.isBlank(sign)) {

            log.error("api request data not completed, timeStamp:{}, data:{}, sign:{}", timeStamp, data, sign);

            throw new RuntimeException("api request data not completed");

        }

    }



}
