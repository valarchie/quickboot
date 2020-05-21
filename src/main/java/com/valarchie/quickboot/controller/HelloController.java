package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.entity.User;
import com.valarchie.quickboot.service.AsynService;
import com.valarchie.quickboot.service.CaffeineService;
import com.valarchie.quickboot.service.HelloService;
import com.valarchie.quickboot.service.ServiceUtil;
import com.valarchie.quickboot.view.vo.HelloParam;
import com.valarchie.quickboot.view.vo.response.UserListVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Swagger模板 以及缓存测试模板
 * Created by
 * @author: valarchie
 * on 2020/2/26 9:53
 * mailbox:343928303@qq.com
 **/
@Api(value = "用户模块", description = "关于用户模块的一系列接口", position = 1, tags = {"用户模块"})
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private AsynService asynService;
    @Autowired
    private CaffeineService caffeineService;


    @ApiOperation(value = "发送信息", notes = "向用户发送问好信息", response = UserListVO.class)
    @PostMapping(value = "/world")
    @ResponseBody
    public ResponseResult hello(@RequestBody @Valid HelloParam param) {

        String msg = "hello, " + param.getName();
        // 测试异步
//        asynService.asynMethod("lily");
        helloService.hello();
        // 测试使用全局Service访问点
//        ServiceUtil.helloService().hello();

        return ResponseResult.success().data("msg", msg);

    }

    @ApiOperation(value = "添加用户", notes = "新增一个用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query", example =
                    "valarchie"),
            @ApiImplicitParam(name = "key", value = "用户id", dataType = "long", paramType = "query", example = "1")
    }
    )
    @RequestMapping("/putUser")
    @ResponseBody
    public ResponseResult putUser(String name, String key) {

        caffeineService.putUser(key, name);

        return ResponseResult.success();

    }


    @ApiOperation(value = "获取用户", notes = "获取一个用户", httpMethod = "POST")
    @RequestMapping("/getUser")
    @ResponseBody
    public ResponseResult getUser(String key) {

        String user = caffeineService.getUser(key);

        System.out.println(user);

        return ResponseResult.success().data("user", user);

    }


    @ApiOperation(value = "清除用户", notes = "清除一个用户", httpMethod = "POST")
    @RequestMapping("/cleanUser")
    @ResponseBody
    public ResponseResult cleanUser(String key) {

        caffeineService.cleanUser(key);

        return ResponseResult.success();

    }

}
