package com.valarchie.quickboot.demo.interfaces.controller;


import com.valarchie.quickboot.core.common.api.ResponseResult;
import com.valarchie.quickboot.core.common.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping("/put")
    @ResponseBody
    public ResponseResult put() {

        redisUtil.set("name", "valarchie呀");

        return ResponseResult.success();

    }

    @RequestMapping("/get")
    @ResponseBody
    public ResponseResult get() {

        Object name = redisUtil.get("name");

        return ResponseResult.success().data("name", name);

    }



}