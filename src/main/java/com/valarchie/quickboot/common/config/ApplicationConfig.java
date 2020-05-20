package com.valarchie.quickboot.common.config;

import com.valarchie.quickboot.common.exception.ExceptionFilter;
import com.valarchie.quickboot.common.filter.ApiDecryptFilter;
import com.valarchie.quickboot.common.filter.SimpleDecryptFilter;
import com.valarchie.quickboot.service.AsynService;
import com.valarchie.quickboot.service.CaffeineService;
import com.valarchie.quickboot.service.HelloService;
import com.valarchie.quickboot.service.impl.AsynServiceImpl;
import com.valarchie.quickboot.service.impl.CaffeineServiceImpl;
import com.valarchie.quickboot.service.impl.HelloServiceImpl;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* description: 本项目的配置
* @author: valarchie
* on: 2020/5/18
* @email: 343928303@qq.com
*/
@Configuration
public class ApplicationConfig {



//    @Bean
    public FilterRegistrationBean apiDecryptFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        ApiDecryptFilter apiFilter = new ApiDecryptFilter();

        registration.setFilter(apiFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("apiDecryptFilter");
        //执行次序
        registration.setOrder(2);

        return registration;
    }

//    @Bean
    public FilterRegistrationBean simpleDecryptFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        SimpleDecryptFilter simpleDecryptFilter = new SimpleDecryptFilter();

        registration.setFilter(simpleDecryptFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("simpleDecryptFilter");
        //执行次序
        registration.setOrder(2);

        return registration;
    }


//    @Bean
    public FilterRegistrationBean exceptionFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

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
    public CaffeineService caffeinService() {
        return new CaffeineServiceImpl();
    }


}