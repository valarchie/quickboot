package com.valarchie.quickboot.common.filter;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * description: 异常过滤器
 * @author: valarchie
 * on: 2020/5/18
 * @email: 343928303@qq.com
 */
@Slf4j
//@WebFilter(filterName = "ExceptionFilter", urlPatterns = "/*")
public class ExceptionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("sssssssssssssssssssssssssssssssssss");
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 异常捕获，发送到error controller
            request.setAttribute("filter.error", e);
            //将异常分发到/error/exthrow控制器
            request.getRequestDispatcher("/error/throw").forward(request, response);

        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }
}
