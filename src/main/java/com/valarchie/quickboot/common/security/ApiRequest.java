package com.valarchie.quickboot.common.security;

import cn.hutool.core.util.StrUtil;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * @Author dongshen
 * @Date 2020-04-21 17:00
 */
@Data
@Slf4j
public class ApiRequest {

    private Long timeStamp;

    private ApiParameters data;

    private String sign;

    public ApiRequest(Long timeStamp, ApiParameters data, String sign) {

        if (timeStamp == null || data == null || StrUtil.isBlank(sign)) {

            log.error("api request data not completed, timeStamp:{}, data:{}, sign:{}", timeStamp, data, sign);

            throw new RuntimeException("api request data not completed");

        }

    }



}
