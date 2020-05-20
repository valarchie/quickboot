package com.valarchie.quickboot.controller;


import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.common.api.ResultCodeEnum;
import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.view.vo.UserParam;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
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
