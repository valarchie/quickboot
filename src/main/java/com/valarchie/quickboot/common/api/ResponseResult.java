package com.valarchie.quickboot.common.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 返回实体
 *
 * @author: valarchie
 * on: 2020/5/14
 * @email: 343928303@qq.com
 */
@Data
@ApiModel
public class ResponseResult {

    /**
     * 返回的错误码
     */
    @ApiParam(name = "错误码")
    private Integer errorCode;

    /**
     * 返回的数据
     */
    @ApiParam(name = "数据")
    private Map<String, Object> data;

    /**
     * 返回的信息
     */
    @ApiParam(name = "返回消息")
    private String message;


    public static ResponseResult success() {

        ResponseResult result = new ResponseResult();

        result.setErrorCode(0);
        result.setData(new HashMap<>(8));
        result.setMessage("请求成功");

        return result;
    }

    public static ResponseResult error(ResultCodeEnum resultCodeEnum) {

        ResponseResult result = new ResponseResult();

        result.setErrorCode(resultCodeEnum.code());
        result.setData(new HashMap<>(8));
        result.setMessage(resultCodeEnum.message());

        return result;

    }

    /**
     * 特殊的错误结果
     * @param resultCodeEnum
     * @param specCode 特殊错误码
     * @param specMsg 特殊错误信息
     * @return
     */
    public static ResponseResult error(ResultCodeEnum resultCodeEnum, Integer specCode, String specMsg) {

        ResponseResult result = new ResponseResult();

        result.setErrorCode(resultCodeEnum.code() + specCode);
        result.setData(new HashMap<>(8));
        result.setMessage(resultCodeEnum.message() + ":" + specMsg);

        return result;

    }

    /**
     * 特殊的错误结果
     * @param resultCodeEnum
     * @param specMsg 特殊错误信息
     * @return
     */
    public static ResponseResult error(ResultCodeEnum resultCodeEnum, String specMsg) {

        ResponseResult result = new ResponseResult();

        result.setErrorCode(resultCodeEnum.code());
        result.setData(new HashMap<>(8));
        result.setMessage(resultCodeEnum.message() + ":" + specMsg);

        return result;

    }


    public ResponseResult data(String key, Object value) {

        data.put(key, value);

        return this;
    }


}