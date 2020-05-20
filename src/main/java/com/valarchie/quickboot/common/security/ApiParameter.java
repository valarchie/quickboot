package com.valarchie.quickboot.common.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Created by
 *
 * @author: valarchie
 * on: 2020/4/21
 * @email: 343928303@qq.com
 */
@Data
public class ApiParameter {

    public final static String MODULE_KEY = "module";
    public final static String FUNCTION_KEY = "function";
    public final static String PARAMETERS_KEY = "parameters";

    private String module;

    private String function;

    private Map<String, String[]> parameters;

    public ApiParameter(String module, String function, String paramJsonStr, IApiDecrypter decrypter) {

        if (StrUtil.isBlank(module) || StrUtil.isBlank(function)) {
            throw new RuntimeException("module or function params not exist!");
        }

        this.module = decrypter.decryptParameter(module);
        this.function = decrypter.decryptParameter(function);
        this.parameters = new HashMap<>();

        if (StrUtil.isNotBlank(paramJsonStr)) {

            String decryptParamJsonStr = decrypter.decryptParameter(paramJsonStr);
            Map map = JSON.parseObject(decryptParamJsonStr, Map.class);

            // 要转换成request bean中所需的map格式
            if (CollUtil.isNotEmpty(map.entrySet())) {

                Set<Map.Entry> entries = map.entrySet();

                for (Map.Entry entry : entries) {

                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.parameters.put(entry.getKey().toString(), new String[]{entry.toString()});
                    }

                }

            }

        }

    }


    /**
     * 由ApiRequest对象生成的参数map直接填入，不用解密，所以传入空操作的IApiDecrypter不做解密处理
     *
     * @param map
     */
    public ApiParameter(Map<String, String> map) {

        this(map.get(ApiParameter.MODULE_KEY), map.get(ApiParameter.FUNCTION_KEY), map.get(ApiParameter.PARAMETERS_KEY), parameter -> parameter);

    }


    /**
     * 获取自定义的请求路径
     *
     * @return
     */
    public String getDecryptRequestPath() {

        return "/" + this.module + "/" + this.function;

    }


}
