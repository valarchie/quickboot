package com.valarchie.quickboot.common.filter;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Map.Entry;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.annotation.Order;

/**
 * Created by author:valarchie on 2020/4/16 21:25 mailbox:343928303@qq.com
 **/
@WebFilter(filterName = "DecryptFilter", urlPatterns = "/*")
@Order(1)
public class DecryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        System.out.println("进行解密！");

        Map<String, String[]> parameterMap = request.getParameterMap();

        Map<String, String[]> overrideParameterMap = new HashMap<>();

        // 依次解密参数集合
//        for (Map.Entry<String, String[]> paramEntry : parameterMap.entrySet()) {
//
//            overrideParameterMap.put(paramEntry.getKey(), paramEntry.getValue());
//
//        }

        String[] modules = parameterMap.get("module");
        String[] functions = parameterMap.get("function");
        // 参数base64串为 eyJuYW1lIjoidG9tIiwiYWdlIjoyMSwiYWRkcmVzcyI6ImJlaWppbmcifQ
        String[] parameters = parameterMap.get("parameters");

        String path = Base64.decodeStr(modules[0]) + "/" + Base64.decodeStr(functions[0]);

        String parameterJsonstr = Base64.decodeStr(parameters[0]);

        JSONObject parametersJSON = JSON.parseObject(parameterJsonstr);

        for (Entry<String, Object> parameter : parametersJSON.entrySet()) {

            System.out.println(parameter.getValue());

            overrideParameterMap.put(parameter.getKey(), new String[]{parameter.getValue().toString()});

        }

        System.out.println(overrideParameterMap);

//        overrideParameterMap.putAll(parameterMap);

//        request.setAttribute("address","beijing");

//        overrideParameterMap.put("address", new String[]{"beijing"});

        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request,
            overrideParameterMap, path);

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
//        Map<String, String[]> overrideParameterMap = new HashMap<>();
//
//        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
//
//            overrideParameterMap.put(stringEntry.getKey(), stringEntry.getValue());
//
//        }
//
////        overrideParameterMap.putAll(parameterMap);
//
////        request.setAttribute("address","beijing");
//
//        overrideParameterMap.put("address", new String[]{"beijing"});
//
//        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request, overrideParameterMap);
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
