package com.valarchie.quickboot.controller;


import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.view.vo.UserParam;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map hello(UserParam param) {

        log.info("functionName ：{}，parameterNames：{}", "good", param.toString());

//        List<User> users = userMapper.selectList(null);

//        System.out.println(users);

        Map responseMap = new HashMap();

        responseMap.put("msg", "欢迎回来！");

//        responseMap.put("user", users);

//        IUserAccountService userAccountService = new UserAccountServiceImpl();
//
//        int count = userAccountService.count(new QueryWrapper<UserAccount>().select());

        return responseMap;

    }

}
