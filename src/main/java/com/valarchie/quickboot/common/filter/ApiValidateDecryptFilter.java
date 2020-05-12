package com.valarchie.quickboot.common.filter;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.valarchie.quickboot.common.security.ApiValidateRequest;
import com.valarchie.quickboot.common.security.IApiDecrypter;
import com.valarchie.quickboot.common.security.SecurityDefine;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 校验并转发请求。 请求格式分为timestamp-data-sign
 * data中包含请求路径以及参数
 * Created by
 * @author: valarchie
 * on: 2020/4/21
 * @email: 343928303@qq.com
 */
//@WebFilter(filterName = "ValidateDecryptFilter", urlPatterns = "/*")
@Slf4j
public class ApiValidateDecryptFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.debug("check decrypt work...");

        Map<String, String[]> requestParameterMap = request.getParameterMap();

        log.debug("start decrypt request data : {}", requestParameterMap);

        String[] timestamp = requestParameterMap.get(ApiValidateRequest.TIMESTAMP_KEY);

        String[] data = requestParameterMap.get(ApiValidateRequest.DATA_KEY);

        String[] sign = requestParameterMap.get(ApiValidateRequest.SIGN_KEY);

        if (ArrayUtil.isEmpty(timestamp)) {
            log.error("request encrypt data not completed ! timestamp is empty !");
            throw new RuntimeException("timestamp参数为空！");
        }

        if (ArrayUtil.isEmpty(data)) {
            log.error("request encrypt data not completed ! data is empty !");
            throw new RuntimeException("data参数为空！");
        }

        if (ArrayUtil.isEmpty(sign)) {
            log.error("request encrypt data not completed ! sign is empty !");
            throw new RuntimeException("sign参数为空！");
        }

        ApiValidateRequest apiRequest = new ApiValidateRequest(timestamp[0], data[0], sign[0], new IApiDecrypter() {
            @Override
            public String decryptParameter(String parameter) {
                // 将前台传回的加密参数先用base64解成字节数组
                byte[] bytes = Base64.decode(parameter);
                // 将字节数组进行解密
                AES aes = SecureUtil.aes(SecurityDefine.AES_KEY.getBytes());

                byte[] decrypt = aes.decrypt(bytes);

                return new String(decrypt);
            }

        });

        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request,
                apiRequest.getData().getParameters(), apiRequest.getData().getDecryptRequestPath());

        chain.doFilter(decryptRequestWrapper, response);

    }

    @Override
    public void destroy() {

    }


}
