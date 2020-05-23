package com.valarchie.quickboot.application.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* description: MybatisPlus 分页配置
* @author: valarchie
* on: 2020/5/22
* @email: 343928303@qq.com
*/
@Configuration
public class MybatisPlusConfig {


    /**
     *   mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        return page;
    }

}
