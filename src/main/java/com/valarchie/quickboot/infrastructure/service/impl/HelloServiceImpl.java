package com.valarchie.quickboot.infrastructure.service.impl;

import com.valarchie.quickboot.infrastructure.service.HelloService;

/**
* description:
* @author: valarchie
* on: 2020/5/18
* @email: 343928303@qq.com
*/
public class HelloServiceImpl implements HelloService {
    @Override
    public void hello() {
        System.out.println("hello world !");
    }
}