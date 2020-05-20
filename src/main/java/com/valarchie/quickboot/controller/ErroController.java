package com.valarchie.quickboot.controller;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.common.api.ResultCodeEnum;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 错误页面控制器
 *
 * @author: valarchie
 * on: 2020/5/18
 * @email: 343928303@qq.com
 */
@Controller
public class ErroController {


    @RequestMapping("/error/throw")
    @ResponseBody
    public ResponseResult error(String msg) {

        return ResponseResult.error(ResultCodeEnum.API_ERROR, msg);

    }

}