package com.valarchie.quickboot.demo.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* description: 全局静态方法访问Service
* @author: valarchie
* on: 2020/5/19
* @email: 343928303@qq.com
*/
@Component
public class ServiceUtil {

    private static HelloService helloService;

    @Autowired
    public void setHelloService(HelloService bean) {
        helloService = bean;
    }

    private static AsynService asynService;

    @Autowired
    public void setAsynService(AsynService bean) {
        asynService = bean;
    }

    public static HelloService helloService() {
        return helloService;
    }


}