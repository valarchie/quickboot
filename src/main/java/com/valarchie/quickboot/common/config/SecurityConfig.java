package com.valarchie.quickboot.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 安全配置参数
 * @Author valarchie
 * @Date 2020-05-20 16:34
 */
@Component
@ConfigurationProperties(prefix = "project.security")
@Data
public class SecurityConfig {

    private String password;

}
