package com.valarchie.quickboot.demo.application.config;

import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.valarchie.quickboot.demo.infrastructure.service.AsynService;
import com.valarchie.quickboot.demo.infrastructure.service.CaffeineService;
import com.valarchie.quickboot.demo.infrastructure.service.HelloService;
import com.valarchie.quickboot.demo.infrastructure.service.impl.AsynServiceImpl;
import com.valarchie.quickboot.demo.infrastructure.service.impl.CaffeineServiceImpl;
import com.valarchie.quickboot.demo.infrastructure.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ServiceConfig {

    @Bean
    public HelloService helloService() {
        return new HelloServiceImpl();
    }

    @Bean
    public AsynService asynService() {
        return new AsynServiceImpl();
    }

    @Bean
    public CaffeineService caffeineService() {
        return new CaffeineServiceImpl();
    }

    @Bean
    public WxPayService wxPayService(){
        return new WxPayServiceImpl();
    }

}