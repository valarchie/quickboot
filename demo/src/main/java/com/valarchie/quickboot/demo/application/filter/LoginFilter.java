package com.valarchie.quickboot.demo.application.filter;

import com.valarchie.quickboot.demo.application.cache.CacheManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
* description: 登录过滤器
* @author: valarchie
* @date 2020/9/8
* @email: 343928303@qq.com
*/
@Slf4j
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String token = ((HttpServletRequest) request).getHeader("token");

        User user = CacheManager.userCache.getIfPresent(token);

        if (user == null) {
            throw new RuntimeException("用户未登陆，请跳转至登陆页面！");
        }


        chain.doFilter(request, response);

    }




}
