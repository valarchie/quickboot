package com.valarchie.quickboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by
 * author:valarchie
 * on 2020/2/26 9:53
 * mailbox:343928303@qq.com
 **/
@SpringBootApplication
@MapperScan("com.valarchie.quickboot.dao")
public class ApplicationBootrap {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootrap.class, args);
    }

}
