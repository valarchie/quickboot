package com.valarchie.quickboot.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
* description: MVC相关配置
* @author: valarchie
* on: 2020/5/19
* @email: 343928303@qq.com
*/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.uploadFolder}")
    private static String uploadFolder;


    /**
     * 获取上传路径
     * @return String
     */
    public static String getUploadDir(){
        return uploadFolder;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }




}