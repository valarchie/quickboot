package com.valarchie.quickboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by
 * author:valarchie
 * on 2020/2/26 9:53
 * mailbox:343928303@qq.com
 **/
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.valarchie.quickboot.dao")
@ComponentScan("com.valarchie")
@EnableAsync
@EnableCaching
@EnableScheduling
public class ApplicationBootrap {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootrap.class, args);
    }

}
