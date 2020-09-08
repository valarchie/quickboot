package com.valarchie.quickboot.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
* description: 微信相关配置
* @author: valarchie
* on: 2020/9/6
* @email: 343928303@qq.com
*/
@Component
@ConfigurationProperties(prefix = "wechat.open")
@Data
public class WechatOpenProperties {
    /**
     * 设置微信三方平台的appid
     */
    private String componentAppId;

    /**
     * 设置微信三方平台的app secret
     */
    private String componentSecret;

    /**
     * 设置微信三方平台的token
     */
    private String componentToken;

    /**
     * 设置微信三方平台的EncodingAESKey
     */
    private String componentAesKey;


}
