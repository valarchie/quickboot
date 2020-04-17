package com.valarchie.quickboot.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * Created by
 * author:valarchie
 * on 2020/4/16 23:26
 * mailbox:343928303@qq.com
 **/
public class DecryptRequestWrapper extends HttpServletRequestWrapper {


    private Map<String , String[]> params = new HashMap<String, String[]>();


    public DecryptRequestWrapper(HttpServletRequest request, Map<String, String[]> overrideParameterMap) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        //将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(overrideParameterMap);
    }


    //重载一个构造方法
//    public DecryptRequestWrapper(HttpServletRequest request , Map<String , Object> extendParams) {
//        this(request);
//        addAllParameters(extendObject);//这里将扩展参数写入参数表
//    }



    @Override
    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
        String[]values = params.get(name);
        if(values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }


    @Override
    public Enumeration getParameterNames() {

        List<String> parameterNames = new ArrayList<>(params.keySet());

        return new Enumeration() {

            int count = 0;

            public boolean hasMoreElements() {
                return count < params.size();
            }

            public String nextElement() {
                synchronized (params) {
                    if (count < params.size()) {
                        return parameterNames.get(count++);
                    }
                }
                throw new NoSuchElementException("Vector Enumeration");
            }
        };


    }




    @Override
    public String[] getParameterValues(String name) {//同上


        System.out.println("调用"+name);
        return params.get(name);
    }


    @Override
    public Map<String, String[]> getParameterMap() {


        System.out.println(params);
        return params;
    }

//    public void addAllParameters(Map<String , Object>otherParams) {//增加多个参数
//        for(Map.Entry<String , Object>entry : otherParams.entrySet()) {
//            addParameter(entry.getKey() , entry.getValue());
//        }
//    }


//    public void addParameter(String name , Object value) {//增加参数
//        if(value != null) {
//            if(value instanceof String[]) {
//                params.put(name , (String[])value);
//            }else if(value instanceof String) {
//                params.put(name , new String[] {(String)value});
//            }else {
//                params.put(name , new String[] {String.valueOf(value)});
//            }
//        }
//    }



}