package com.valarchie.quickboot.common.security;

import java.util.Map;
import lombok.Data;

/**
 * @Author dongshen
 * @Date 2020-04-21 20:35
 */
@Data
public class ApiParameters {

    private String module;

    private String function;

    private Map parameters;

    public ApiParameters(String module, String function, String parameters, IApiDecrypter decrypter) {


    }

}
