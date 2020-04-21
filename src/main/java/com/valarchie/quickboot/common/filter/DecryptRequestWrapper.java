package com.valarchie.quickboot.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.File;
import java.util.*;

/**
 * Created by
 * author:valarchie
 * on 2020/4/16 23:26
 * mailbox:343928303@qq.com
 **/
public class DecryptRequestWrapper extends HttpServletRequestWrapper {


    private Map<String, String[]> params = new HashMap<String, String[]>();

    private String path;


    public DecryptRequestWrapper(HttpServletRequest request, Map<String, String[]> overrideParameterMap, String path) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(overrideParameterMap);
        this.path = path;
    }



    @Override
    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }


    @Override
    public Enumeration getParameterNames() {

        List<String> parameterNames = new ArrayList<>(params.keySet());

        return new Enumeration() {

            int count = 0;

            @Override
            public boolean hasMoreElements() {
                return count < params.size();
            }

            @Override
            public String nextElement() {
                synchronized (params) {
                    if (count < params.size()) {
                        return parameterNames.get(count++);
                    }
                }
                throw new NoSuchElementException("No more elements in enumeration!");
            }

        };


    }

    @Override
    public String getRequestURI() {
        return path;
    }


    @Override
    public String getServletPath() {
        return path;
    }

    @Override
    public String[] getParameterValues(String name) {
        return params.get(name);
    }


    @Override
    public Map<String, String[]> getParameterMap() {
        return params;
    }




}
