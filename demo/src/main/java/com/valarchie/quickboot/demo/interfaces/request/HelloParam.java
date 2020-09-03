package com.valarchie.quickboot.demo.interfaces.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
* description: hello参数模型
* @author: valarchie
* on: 2020/5/21
* @email: 343928303@qq.com
*/
@ApiModel
@Data
@ToString
public class HelloParam {

    @NotBlank
    @ApiModelProperty(value ="姓名", example = "valarchie")
    private String name;

    @NotBlank
    @ApiModelProperty(value = "消息内容", example = "good")
    private String msg;

    @ApiModelProperty(value = "用户详细信息", example = "boy")
    private UserParam user;

}