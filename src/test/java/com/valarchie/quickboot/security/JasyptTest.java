package com.valarchie.quickboot.security;


import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: api请求加密生成
 *
 * @author: valarchie
 * on: 2020/4/22
 * @email: 343928303@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encrypt() {
        System.out.println("PWD: " + stringEncryptor.encrypt("123456789"));
    }

}