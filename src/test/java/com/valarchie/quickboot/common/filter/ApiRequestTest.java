package com.valarchie.quickboot.common.filter;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;
import com.alibaba.fastjson.JSONObject;
import com.valarchie.quickboot.common.security.SecurityDefine;
import com.valarchie.quickboot.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * description: api请求加密生成
 *
 * @author: valarchie
 * on: 2020/4/22
 * @email: 343928303@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiRequestTest {


    @Test
    public void generateApiRequest() {


        JSONObject data = new JSONObject();

        data.put("module", "home");
        data.put("function", "good");

        JSONObject parameters = new JSONObject();

        parameters.put("name", "tom");
        parameters.put("age", 11);
        parameters.put("address", "beijing");

        data.put("parameters", parameters.toJSONString());

        AES aes = SecureUtil.aes(SecurityDefine.AES_KEY.getBytes());
        byte[] encrypt = aes.encrypt(data.toJSONString());
        String encryptBase64 = Base64.encode(encrypt);

        Long timeStamp = DateUtil.currentSeconds();

        String sign = DigestUtil.md5Hex(timeStamp.toString() + data.toJSONString());

        System.out.println(timeStamp);
        System.out.println(data.toJSONString());
        System.out.println("timestamp:" + timeStamp);
        System.out.println("data:" + encryptBase64);
        System.out.println("sign:" + sign);

    }


}