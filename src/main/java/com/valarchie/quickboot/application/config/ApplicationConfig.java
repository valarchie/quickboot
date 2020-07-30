package com.valarchie.quickboot.application.config;

import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import com.valarchie.quickboot.application.common.exception.ExceptionFilter;
import com.valarchie.quickboot.application.common.filter.ApiDecryptFilter;
import com.valarchie.quickboot.application.common.filter.SimpleDecryptFilter;
import com.valarchie.quickboot.infrastructure.service.AsynService;
import com.valarchie.quickboot.infrastructure.service.CaffeineService;
import com.valarchie.quickboot.infrastructure.service.HelloService;
import com.valarchie.quickboot.infrastructure.service.impl.AsynServiceImpl;
import com.valarchie.quickboot.infrastructure.service.impl.CaffeineServiceImpl;
import com.valarchie.quickboot.infrastructure.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
* description: 本项目的配置
* @author: valarchie
* on: 2020/5/18
* @email: 343928303@qq.com
*/
@Slf4j
@Configuration
public class ApplicationConfig {

    @Autowired
    StringEncryptor stringEncryptor;


    @ConditionalOnProperty(value = "project.security.complex-filter")
    @Bean
    public FilterRegistrationBean apiDecryptFilterRegistration() {

        FilterRegistrationBean<ApiDecryptFilter> registration = new FilterRegistrationBean<>();

        ApiDecryptFilter apiFilter = new ApiDecryptFilter();

        registration.setFilter(apiFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("apiDecryptFilter");
        //执行次序
        registration.setOrder(2);

        log.info("{} is register success! ", apiFilter.getClass().getSimpleName());

        return registration;
    }

    @ConditionalOnProperty(value = "project.security.simple-filter")
    @Bean
    public FilterRegistrationBean simpleDecryptFilterRegistration() {

        FilterRegistrationBean<SimpleDecryptFilter> registration = new FilterRegistrationBean<>();

        SimpleDecryptFilter simpleDecryptFilter = new SimpleDecryptFilter();

        registration.setFilter(simpleDecryptFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("simpleDecryptFilter");
        //执行次序
        registration.setOrder(2);

        log.info("{} is register success! ", simpleDecryptFilter.getClass().getSimpleName());

        return registration;
    }


    @Bean
    public FilterRegistrationBean exceptionFilterRegistration() {

        FilterRegistrationBean<ExceptionFilter> registration = new FilterRegistrationBean<>();

        ExceptionFilter exceptionFilter = new ExceptionFilter();

        registration.setFilter(exceptionFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("exceptionFilter");
        //执行次序
        registration.setOrder(1);

        return registration;
    }


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



}