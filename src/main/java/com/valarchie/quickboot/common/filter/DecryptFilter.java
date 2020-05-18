package com.valarchie.quickboot.common.filter;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ArrayUtil;
import com.valarchie.quickboot.common.security.ApiParameter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 解密请求参数： 参数分为module/function/parameters 均需要解密
 * Created by
 * @author: valarchie
 * on: 2020/4/21
 * @email: 343928303@qq.com
 */
@WebFilter(filterName = "DecryptFilter", urlPatterns = "/*")
@Slf4j
public class DecryptFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Map<String, String[]> requestParameterMap = request.getParameterMap();

        log.debug("start decrypt request data : {}", requestParameterMap);

        // 模块base64串为 aG9tZQ==
        String[] modules = requestParameterMap.get(ApiParameter.MODULE_KEY);
        // 方法base64串为 Z29vZA==
        String[] function = requestParameterMap.get(ApiParameter.FUNCTION_KEY);
        // 参数base64串为 eyJuYW1lIjoidG9tIiwiYWdlIjoyMSwiYWRkcmVzcyI6ImJlaWppbmcifQ
        String[] parameters = requestParameterMap.get(ApiParameter.PARAMETERS_KEY);

        if (ArrayUtil.isAllEmpty(modules, function)) {

            log.error("request data not completed ! module or function is empty !");
            throw new RuntimeException("module或function参数为空！");

        }

        // 将请求参数交给apiParameter进行处理，此次使用base64加密作为演示 如果不用解密的话 不作任何处理原字符串返回
        ApiParameter apiParameter = new ApiParameter(modules[0], function[0], parameters[0], parameter -> Base64.decodeStr(parameter));
        // 获取解密后的请求路径
        String requestPath = apiParameter.getDecryptRequestPath();

        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request,
                apiParameter.getParameters(), requestPath);

        chain.doFilter(decryptRequestWrapper, response);

    }




}
