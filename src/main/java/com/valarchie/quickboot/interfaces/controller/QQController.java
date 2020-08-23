package com.valarchie.quickboot.interfaces.controller;

import com.valarchie.quickboot.application.common.api.ResponseResult;
import com.valarchie.quickboot.application.common.auth.qq.QQService;
import com.valarchie.quickboot.application.common.auth.qq.UserInfo;
import com.valarchie.quickboot.interfaces.request.apps.LoginByQQAppRequest;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/apps/user/")
public class QQController {

    @Autowired
    private QQService qqService;


    @RequestMapping("/loginByQQApp")
    @ResponseBody
    public ResponseResult login(LoginByQQAppRequest loginByQQAppRequest) {

        UserInfo userInfo =
                qqService.getUserInfo(loginByQQAppRequest.getOpenid(),
                        loginByQQAppRequest.getCode());

        return ResponseResult.success().data("user", userInfo);

    }


}