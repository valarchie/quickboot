package com.valarchie.quickboot.infrastructure.controller;


import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.util.RedisUtil;
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