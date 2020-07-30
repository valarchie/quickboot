package com.valarchie.quickboot.interfaces.controller;

import com.valarchie.quickboot.application.common.api.ResponseResult;
import com.valarchie.quickboot.application.common.mail.MailService;
import com.valarchie.quickboot.infrastructure.service.AsynService;
import com.valarchie.quickboot.infrastructure.service.CaffeineService;
import com.valarchie.quickboot.infrastructure.service.HelloService;
import com.valarchie.quickboot.interfaces.request.HelloParam;
import com.valarchie.quickboot.interfaces.response.UserListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Swagger模板 以及缓存测试模板
 * Created by
 * @author: valarchie
 * on 2020/2/26 9:53
 * mailbox:343928303@qq.com
 **/
@Api(value = "邮件模块", description = "关于邮件模块的一系列接口", position = 1, tags = {"邮件模块"})
@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/sendMail")
    @ResponseBody
    public ResponseResult sendMail() {

        mailService.sendSimpleMailMessge("644461992@qq.com","hello","testing email");

        return ResponseResult.success().data("msg", "发送邮件成功");

    }



}
