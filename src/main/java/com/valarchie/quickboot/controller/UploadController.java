package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.service.AsynService;
import com.valarchie.quickboot.service.CaffeineService;
import com.valarchie.quickboot.service.HelloService;
import com.valarchie.quickboot.service.ServiceUtil;
import com.valarchie.quickboot.view.vo.HelloParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
* description: 上传控制器
* @author: valarchie
* on: 2020/5/19
* @email: 343928303@qq.com
*/
@ApiIgnore
@Controller
@RequestMapping("/upload")
public class UploadController {



    @PostMapping("/img")
    @ResponseBody
    public ResponseResult img(@RequestParam("file") MultipartFile file) {

        System.out.println(1/0);

        System.out.println(file.getSize());

        System.out.println("上传");

        return ResponseResult.success();
    }


}
