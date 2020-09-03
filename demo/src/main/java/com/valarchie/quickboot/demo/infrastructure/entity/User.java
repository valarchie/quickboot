package com.valarchie.quickboot.demo.infrastructure.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by
 * @author: valarchie
 * on 2020/4/13 23:31
 * mailbox:343928303@qq.com
 **/
@Data
@ApiModel(description = "用户模型")
public class User {

    @ApiModelProperty(value = "用户id",  example = "1")
    private Long id;
    @ApiModelProperty(value = "用户姓名",  example = "archie")
    private String name;
    @ApiModelProperty(value = "年龄", example = "1")
    private Integer age;
    @ApiModelProperty(value = "邮箱", example = "343928303@qq.com")
    private String email;

}


