package com.valarchie.quickboot.demo.interfaces.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by
 * author:valarchie
 * on 2020/4/16 23:17
 * mailbox:343928303@qq.com
 **/
@Data
@ToString
@ApiModel
public class UserParam {

    @NotNull
    @NotBlank
    @NotEmpty
    @ApiModelProperty(value = "姓名")
    private String name;

    @NotNull
    @Max(120)
    @ApiModelProperty(value = "年龄")
    private Short age;

    @NotNull
    @NotBlank
    @Length(min = 3)
    @ApiModelProperty(value = "用户地址")
    private String address;


}
