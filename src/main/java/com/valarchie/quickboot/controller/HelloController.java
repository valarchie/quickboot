package com.valarchie.quickboot.controller;


import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by
 * author:valarchie
 * on 2020/2/26 9:53
 * mailbox:343928303@qq.com
 **/
@Controller
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    @ResponseBody
    public Map hello() {

//        List<User> users = userMapper.selectList(null);

//        System.out.println(users);

        Map responseMap = new HashMap();

        System.out.println("进入hello方法！");

//        responseMap.put("user", users);

//        IUserAccountService userAccountService = new UserAccountServiceImpl();
//
//        int count = userAccountService.count(new QueryWrapper<UserAccount>().select());

        return responseMap;

    }

}
