package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.common.config.SecurityConfig;
import com.valarchie.quickboot.dao.UserMapper;
import com.valarchie.quickboot.view.vo.UserParam;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
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
