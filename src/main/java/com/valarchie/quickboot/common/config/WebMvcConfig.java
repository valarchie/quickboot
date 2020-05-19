package com.valarchie.quickboot.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
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


}