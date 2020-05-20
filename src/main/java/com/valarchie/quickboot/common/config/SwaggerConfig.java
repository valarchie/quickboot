package com.valarchie.quickboot.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* description: swagger自动文档生成配置
* http://localhost:8080/v2/api-docs 默认访问地址
* @author: valarchie
* on: 2020/5/20
* @email: 343928303@qq.com
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径 也可以填RequestHandlerSelectors.any() 全包
                .apis(RequestHandlerSelectors.basePackage("com.valarchie.quickboot.controller"))
                // 扫描全路径
                .paths(PathSelectors.any())
                .build();

    }


    /**
     * 构建Api文档的详细操作
     * @return
     */
    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                //页面标题
                .title("quickboot项目接口文档")
                //创建人
                .contact(new Contact("valarchie", "vc2x.com", "343928303@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("基于springboot的小型快速开发框架。")
                .build();


        return apiInfo;
    }

}