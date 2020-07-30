package com.valarchie.quickboot.security;


import com.valarchie.quickboot.application.ApplicationStarter;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: api请求加密生成
 *
 * @author: valarchie
 * on: 2020/4/22
 * @email: 343928303@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationStarter.class)
public class JasyptTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encrypt() {
        System.out.println("PWD: " + stringEncryptor.encrypt("tgplyzryhiqdbgjf"));
    }

}