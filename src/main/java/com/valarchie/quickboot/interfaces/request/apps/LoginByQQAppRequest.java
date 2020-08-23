package com.valarchie.quickboot.interfaces.request.apps;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用QQ登录请求参数
 */
@Data
public class LoginByQQAppRequest {

    @NotNull
    @NotBlank
    private String code;

    @NotNull
    @NotBlank
    private String openid;

}