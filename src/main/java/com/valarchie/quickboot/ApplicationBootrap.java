package com.valarchie.quickboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

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
public class ApplicationBootrap {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootrap.class, args);
    }

}
