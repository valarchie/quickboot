package com.valarchie.quickboot.demo.interfaces.controller;

import com.valarchie.quickboot.core.common.api.ResponseResult;
import com.valarchie.quickboot.core.common.auth.qq.QQService;
import com.valarchie.quickboot.core.common.auth.qq.UserInfo;
import com.valarchie.quickboot.demo.interfaces.request.apps.LoginByQQAppRequest;
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