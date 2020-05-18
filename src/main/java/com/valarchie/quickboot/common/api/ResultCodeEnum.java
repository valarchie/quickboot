package com.valarchie.quickboot.common.api;

/**
 * description: 响应码规范
 *
 * @author: valarchie
 * on: 2020/5/18
 * @email: 343928303@qq.com
 */
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS(0, "请求成功"),
    API_ERROR(10000, "请求错误"),
    PARAM_ERROR(20000, "参数错误"),
    BUSINESS_ERROR(30000, "业务逻辑错误");

    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }

}
