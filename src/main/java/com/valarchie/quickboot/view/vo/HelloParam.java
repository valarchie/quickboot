package com.valarchie.quickboot.view.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.ToString;

@ApiModel
@Data
@ToString
public class HelloParam {

    @ApiParam(value ="姓名")
    private String name;

}