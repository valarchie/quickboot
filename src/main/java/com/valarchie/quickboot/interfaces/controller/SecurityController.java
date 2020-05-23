package com.valarchie.quickboot.interfaces.controller;

import com.valarchie.quickboot.application.common.api.ResponseResult;
import com.valarchie.quickboot.application.config.SecurityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author valarchie
 * @Date 2020-05-20 16:36
 */
@ApiIgnore
@Controller
@RequestMapping("/security")
@Slf4j
public class SecurityController {

    @Autowired
    private SecurityConfig securityConfig;

    @RequestMapping("/password")
    @ResponseBody
    public ResponseResult password() {

        return ResponseResult.success().data("msg", securityConfig.getPassword());

    }


}
