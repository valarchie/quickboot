package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.service.AsynService;
import com.valarchie.quickboot.service.CaffeineService;
import com.valarchie.quickboot.service.HelloService;
import com.valarchie.quickboot.service.ServiceUtil;
import com.valarchie.quickboot.view.vo.HelloParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
    @Autowired
    private AsynService asynService;
    @Autowired
    private CaffeineService caffeineService;

    @RequestMapping("/world")
    @ResponseBody
    public ResponseResult hello(HelloParam param) {


        String msg = "hello, " + param.getName();

//        asynService.asynMethod("lily");
//        helloService.hello();
        ServiceUtil.helloService().hello();

        return ResponseResult.success().data("msg", msg);

    }

    @RequestMapping("/putUser")
    @ResponseBody
    public ResponseResult putUser(String name, String key) {

        caffeineService.putUser(key, name);

        return ResponseResult.success();

    }


    @RequestMapping("/getUser")
    @ResponseBody
    public ResponseResult getUser(String key) {

        String user = caffeineService.getUser(key);

        System.out.println(user);

        return ResponseResult.success().data("user", user);

    }


    @RequestMapping("/cleanUser")
    @ResponseBody
    public ResponseResult cleanUser(String key) {

        caffeineService.cleanUser(key);

        return ResponseResult.success();

    }

}
