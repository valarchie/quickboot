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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Swagger模板 以及缓存测试模板
 * Created by
 *
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

    @RequestMapping("/sendSimpleMessage")
    @ResponseBody
    public ResponseResult sendSimpleMessage() {

        mailService.sendSimpleMessage("644461992@qq.com", "hello", "testing simple email");

        return ResponseResult.success().data("msg", "发送邮件成功");

    }

    @RequestMapping("/sendHtmlMessage")
    @ResponseBody
    public ResponseResult sendHtmlMessage() {

        mailService.sendHtmlMessage("644461992@qq.com", "hello", "<html><body><h1>hello html</h1></body></html>");

        return ResponseResult.success().data("msg", "发送邮件成功");

    }

    @RequestMapping("/sendMimeMessageWithAttachment")
    @ResponseBody
    public ResponseResult sendMimeMessageWithAttachment() {

        String filePath = "C:\\Users\\valarchie\\Desktop\\tom_hardy.jpg";

        mailService.sendMimeMessageWithAttachment("644461992@qq.com", "hello", "testing email", filePath);

        return ResponseResult.success().data("msg", "发送邮件成功");

    }

    @RequestMapping("/sendMimeMessageWithRichMedia")
    @ResponseBody
    public ResponseResult sendMimeMessageWithRichMedia() {

        Map<String, String> resourceMap = new HashMap<>();

        resourceMap.put("pic", "C:\\Users\\valarchie\\Desktop\\tom_hardy.jpg");

        mailService.sendMimeMessageWithRichMedia("644461992@qq.com", "hello", "<html><body><h1>handsome</h1><img " +
                "src=\"cid:pic\"><p></body></html>", resourceMap);

        return ResponseResult.success().data("msg", "发送邮件成功");

    }


}
