package com.valarchie.quickboot.common.filter;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.valarchie.quickboot.common.security.ApiParameter;
import com.valarchie.quickboot.common.security.IApiDecrypter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by
 *
 * @author: valarchie
 * on: 2020/4/21
 * @email: 343928303@qq.com
 */
@WebFilter(filterName = "DecryptFilter", urlPatterns = "/*")
@Slf4j
public class DecryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        Map<String, String[]> requestParameterMap = request.getParameterMap();

        Map<String, String[]> overrideParameterMap = new HashMap<>();

        log.debug("start decrypt request data : {}", requestParameterMap);
        // 模块base64串为 aG9tZQ==
        String[] modules = requestParameterMap.get("module");
        // 方法base64串为 Z29vZA==
        String[] function = requestParameterMap.get("function");
        // 参数base64串为 eyJuYW1lIjoidG9tIiwiYWdlIjoyMSwiYWRkcmVzcyI6ImJlaWppbmcifQ
        String[] parameters = requestParameterMap.get("parameters");

        if (ArrayUtil.isAllEmpty(modules, function)) {

            log.error("request data not completed ! module or function is empty !");
            throw new RuntimeException("module或function参数为空！");

        }

        // 将请求参数交给apiParameter进行处理，此次使用base64加密作为演示 如果不用解密的话 不作任何处理原字符串返回
        ApiParameter apiParameter = new ApiParameter(modules[0], function[0], parameters[0], parameter -> Base64.decodeStr(parameter));

        // 拼接请求路径
        String requestPath = "/" + apiParameter.getModule() + "/" + apiParameter.getFunction();

        overrideParameterMap.putAll(apiParameter.getParameters());

        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request,
                overrideParameterMap, requestPath);

        chain.doFilter(decryptRequestWrapper, response);

    }

    @Override
    public void destroy() {

    }


}
