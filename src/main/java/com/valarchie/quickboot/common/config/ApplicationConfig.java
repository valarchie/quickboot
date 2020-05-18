package com.valarchie.quickboot.common.config;

import com.valarchie.quickboot.common.filter.ApiValidateDecryptFilter;
import com.valarchie.quickboot.common.filter.ExceptionFilter;
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
    public FilterRegistrationBean apiFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        ApiValidateDecryptFilter apiFilter = new ApiValidateDecryptFilter();

        registration.setFilter(apiFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("validateDecryptFilter");
        //执行次序
        registration.setOrder(2);

        return registration;
    }

    @Bean
    public FilterRegistrationBean exceptionFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        ExceptionFilter exceptionFilter = new ExceptionFilter();

        registration.setFilter(exceptionFilter);
        //配置过滤规则
        registration.addUrlPatterns("/*");
        //设置过滤器名称
        registration.setName("exceptionFilter");
        //执行次序
        registration.setOrder(3);

        return registration;
    }


}