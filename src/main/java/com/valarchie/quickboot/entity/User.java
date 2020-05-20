package com.valarchie.quickboot.entity;

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

    @ApiModelProperty(value = "id", name = "用户id")
    private Long id;
    @ApiModelProperty(value = "name", name = "用户姓名")
    private String name;
    private Integer age;
    private String email;

}


