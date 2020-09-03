package com.valarchie.quickboot.demo.interfaces.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
* description: 添加商店的参数模型
* @author: valarchie
* on: 2020/5/22
* @email: 343928303@qq.com
*/
@Data
public class AddShopParam {

    @NotNull
    @NotBlank
    @ApiModelProperty("商店名称")
    private String shop;

    @NotNull
    @Positive
    @ApiModelProperty("商品类型")
    private Integer productType;

    @NotNull
    @NotBlank
    @ApiModelProperty("店长")
    private String shopMen;


}