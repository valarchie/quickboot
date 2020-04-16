package com.valarchie.quickboot.common.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by
 * author:valarchie
 * on 2020/4/16 21:25
 * mailbox:343928303@qq.com
 **/
@WebFilter(filterName = "DecryptFilter", urlPatterns = "/hello")
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

        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {

            overrideParameterMap.put(stringEntry.getKey(), stringEntry.getValue());

        }

//        overrideParameterMap.putAll(parameterMap);

//        request.setAttribute("address","beijing");

        overrideParameterMap.put("address", new String[]{"beijing"});

        DecryptRequestWrapper decryptRequestWrapper = new DecryptRequestWrapper((HttpServletRequest) request, overrideParameterMap);


        RequestDispatcher requestDispatcher = decryptRequestWrapper.getRequestDispatcher("/home/good");

        requestDispatcher.forward(decryptRequestWrapper, response);

        chain.doFilter(decryptRequestWrapper, response);
    }

    @Override
    public void destroy() {

    }


}
