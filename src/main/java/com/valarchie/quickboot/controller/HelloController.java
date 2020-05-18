package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.service.HelloService;
import com.valarchie.quickboot.view.vo.HelloParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * @author: valarchie
 * on 2020/2/26 9:53
 * mailbox:343928303@qq.com
 **/
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/world")
    @ResponseBody
    public ResponseResult hello(HelloParam param) {

        String msg = "hello, " + param.getName();

        helloService.hello();

        return ResponseResult.success().data("msg", msg);

    }

}
