package com.valarchie.quickboot.infrastructure.controller;


import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.common.api.ResultCodeEnum;
import com.valarchie.quickboot.infrastructure.mapper.UserMapper;
import com.valarchie.quickboot.infrastructure.vo.request.UserParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
* description: 测试控制器
* @author: valarchie
* on: 2020/5/20
* @email: 343928303@qq.com
*/
@ApiIgnore
@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/good")
    @ResponseBody
    public ResponseResult hello(@Valid UserParam param) {

        log.info("functionName ：{}，parameterNames：{}", "good", param.toString());

//        List<User> users = userMapper.selectList(null);

//        System.out.println(users);

        Map responseMap = new HashMap();

        responseMap.put("msg", "welcome to home 哈哈哈");

//        responseMap.put("user", users);

//        IUserAccountService userAccountService = new UserAccountServiceImpl();
//
//        int count = userAccountService.count(new QueryWrapper<UserAccount>().select());

        return ResponseResult.success().data("msg","hahahah");

    }

    @RequestMapping("/apierror")
    @ResponseBody
    public ResponseResult apierror(@Valid UserParam param) {

        log.info("functionName ：{}，parameterNames：{}", "good", param.toString());

        if (1 == 1) {
            throw new RuntimeException("报错了！");

        }


        return ResponseResult.error(ResultCodeEnum.API_ERROR);

    }

    @RequestMapping("/apierror2")
    @ResponseBody
    public ResponseResult apierror2(@Valid UserParam param) {

        log.info("functionName ：{}，parameterNames：{}", "good", param.toString());

        return ResponseResult.success().data("ss","ss").data("ss1","sssss");

    }


}
