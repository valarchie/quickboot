package com.valarchie.quickboot.controller;


import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.view.vo.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/good")
    @ResponseBody
    public Map hello(UserParam param) {

        System.out.println(param);

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
