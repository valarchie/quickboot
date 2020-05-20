package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.entity.User;
import com.valarchie.quickboot.service.AsynService;
import com.valarchie.quickboot.service.CaffeineService;
import com.valarchie.quickboot.service.HelloService;
import com.valarchie.quickboot.service.ServiceUtil;
import com.valarchie.quickboot.view.vo.HelloParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(value = "用户模块", description = "用户模块")
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private AsynService asynService;
    @Autowired
    private CaffeineService caffeineService;


    @ApiOperation(value = "发送问好", notes="发送问好信息", httpMethod = "GET")
    @RequestMapping(value = "/world", method = RequestMethod.GET)
    @ApiResponse(code = 200, message = "成功" , responseContainer="Map", response = User.class)
    @ResponseBody
    public ResponseResult hello(HelloParam param) {

        String msg = "hello, " + param.getName();
        // 测试异步
//        asynService.asynMethod("lily");
        helloService.hello();
        // 测试使用全局Service访问点
//        ServiceUtil.helloService().hello();

        return ResponseResult.success().data("msg", msg);

    }
//
//    @ApiOperation(value = "添加用户", notes="新增一个用户", httpMethod = "POST")
//    @RequestMapping("/putUser")
//    @ResponseBody
//    public ResponseResult putUser(String name, String key) {
//
//        caffeineService.putUser(key, name);
//
//        return ResponseResult.success();
//
//    }
//
//
//    @ApiOperation(value = "获取用户", notes="获取一个用户", httpMethod = "POST")
//    @RequestMapping("/getUser")
//    @ResponseBody
//    public ResponseResult getUser(String key) {
//
//        String user = caffeineService.getUser(key);
//
//        System.out.println(user);
//
//        return ResponseResult.success().data("user", user);
//
//    }
//
//
//    @ApiOperation(value = "清除用户", notes="清除一个用户", httpMethod = "POST")
//    @RequestMapping("/cleanUser")
//    @ResponseBody
//    public ResponseResult cleanUser(String key) {
//
//        caffeineService.cleanUser(key);
//
//        return ResponseResult.success();
//
//    }

}
