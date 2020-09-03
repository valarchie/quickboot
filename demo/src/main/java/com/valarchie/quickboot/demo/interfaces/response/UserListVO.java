package com.valarchie.quickboot.demo.interfaces.response;

import com.valarchie.quickboot.demo.infrastructure.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * description: 用户列表VO
 *
 * @author: valarchie
 * on: 2020/5/21
 * @email: 343928303@qq.com
 */
@Data
@ApiModel(description = "用户列表模型")
public class UserListVO {

    @ApiModelProperty(name = "用户列表")
    private List<User> userList;

}