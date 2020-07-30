package com.valarchie.quickboot.application.common.exception;

import com.valarchie.quickboot.application.common.api.ResponseResult;
import com.valarchie.quickboot.application.common.api.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * description: 异常过滤器，因为配置的全局异常捕获器只能捕获MVC框架的异常
 * @author: valarchie
 * on: 2020/5/18
 * @email: 343928303@qq.com
 */
@Slf4j
@WebFilter(filterName = "ExceptionFilter", urlPatterns = "/*")
public class ExceptionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 自定义错误信息，转发到特定的错误页面
            e.printStackTrace();
            //将异常分发到/error/exthrow控制器
//            request.getRequestDispatcher("/error/throw?msg=" + e.getMessage()).forward(request, response);
            response.getWriter().write(ResponseResult.error(ResultCodeEnum.API_ERROR, e.getMessage()).toString()+"ssssssssssssssssssssssssssssssssssssss");

        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
