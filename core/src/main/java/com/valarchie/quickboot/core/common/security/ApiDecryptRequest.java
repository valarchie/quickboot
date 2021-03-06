package com.valarchie.quickboot.core.common.security;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Map;
import java.util.Objects;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
* description: api请求数据封装类
* @author: valarchie
* on: 2020/4/21
* @email: 343928303@qq.com
*/
@Data
@Slf4j
public class ApiDecryptRequest {

    public final static String TIMESTAMP_KEY = "timestamp";
    public final static String DATA_KEY = "data";
    public final static String SIGN_KEY = "sign";

    private Long timeStamp;

    private SimpleDecryptRequest data;

    private String sign;

    public ApiDecryptRequest(String timeStampStr, String data, String sign, IApiDecrypter decrypter) {

        if (StrUtil.isBlank(timeStampStr) || StrUtil.isBlank(data) || StrUtil.isBlank(sign)) {

            log.error("api request data not completed, timeStamp:{}, data:{}, sign:{}", timeStampStr, data, sign);

            throw new RuntimeException("api request data not completed");

        }

        if (!NumberUtil.isLong(timeStampStr)) {
            throw new RuntimeException("api request timestamp is invalid!");
        }

        this.timeStamp = Long.valueOf(timeStampStr);

        // 校验timestamp是否过期，超过60秒请求即过期
        if (DateUtil.currentSeconds() - timeStamp > 60000) {
            throw new RuntimeException("api request timestamp is  expired!");
        }

        String decryptDataJsonStr = decrypter.decryptParameter(data);

        this.sign = sign;

        // 检验sign是否有效
        String signed = DigestUtil.md5Hex(timeStampStr + decryptDataJsonStr);

        log.info("timestamp:{}, data:{}, sign:{}", timeStampStr, decryptDataJsonStr, sign);

        if (!Objects.equals(this.sign, signed)) {
            throw new RuntimeException("api request sign is invalid!");
        }

        if (!JSONUtil.isJson(decryptDataJsonStr)) {
            throw new RuntimeException("api request data analysis fail or data not json !");
        }

        Map<String, String> map = JSON.parseObject(decryptDataJsonStr, Map.class);

        SimpleDecryptRequest apiParameter = new SimpleDecryptRequest(map);

        this.data = apiParameter;

    }



}
