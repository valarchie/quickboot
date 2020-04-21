package com.valarchie.quickboot.common.filter;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import lombok.extern.slf4j.Slf4j;

/**
 * Created by author:valarchie on 2020/4/16 21:25 mailbox:343928303@qq.com
 **/
@WebFilter(filterName = "DecryptFilter", urlPatterns = "/*")
@Slf4j
public class DecryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        Map<String, String[]> originParameterMas = request.getParameterMap();

        Map<String, String[]> overrideParameterMaps = new HashMap<>();

        log.debug("start decrypt request data : {}", originParameterMas);

        String[] modules = originParameterMas.get("module");
        String[] functions = originParameterMas.get("function");

        // 参数base64串为 eyJuYW1lIjoidG9tIiwiYWdlIjoyMSwiYWRkcmVzcyI6ImJlaWppbmcifQ
        String[] parameters = originParameterMas.get("parameters");




        String path = Base64.decodeStr(modules[0]) + "/" + Base64.decodeStr(functions[0]);

        String parameterJsonStr = Base64.decodeStr(parameters[0]);

        JSONObject parametersJSON = JSON.parseObject(parameterJsonStr);

        for (Entry<String, Object> parameter : parametersJSON.entrySet()) {

            System.out.println(parameter.getValue());

            overrideParameterMaps.put(parameter.getKey(), new String[]{parameter.getValue().toString()});

        }

        System.out.println(overrideParameterMaps);

//        overrideParameterMaps.putAll(parameterMap);

//        request.setAttribute("address","beijing");

//        overrideParameterMaps.put("address", new String[]{"beijing"});

        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request,
            overrideParameterMaps, path);

//        System.out.println(path);

//        RequestDispatcher requestDispatcher = decryptRequestWrapper.getRequestDispatcher(path);
//
//        requestDispatcher.forward(decryptRequestWrapper, response);

        chain.doFilter(decryptRequestWrapper, response);

//        ============================

//        System.out.println("进行解密！");
//
//        Map<String, String[]> parameterMap = request.getParameterMap();
//
//        Map<String, String[]> overrideParameterMaps = new HashMap<>();
//
//        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
//
//            overrideParameterMaps.put(stringEntry.getKey(), stringEntry.getValue());
//
//        }
//
////        overrideParameterMaps.putAll(parameterMap);
//
////        request.setAttribute("address","beijing");
//
//        overrideParameterMaps.put("address", new String[]{"beijing"});
//
//        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request, overrideParameterMaps);
//
//        RequestDispatcher requestDispatcher = decryptRequestWrapper.getRequestDispatcher("/home/good");
//
//        requestDispatcher.forward(decryptRequestWrapper, response);
//
//        chain.doFilter(decryptRequestWrapper, response);

    }

    @Override
    public void destroy() {

    }


}
