package com.valarchie.quickboot.demo.interfaces.controller;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.valarchie.quickboot.core.common.api.ResponseResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* description:
* @author: valarchie
* on: 2020/8/22
* @email: 343928303@qq.com
*/
@Controller
@RequestMapping("/ali")
public class AliController {


    @RequestMapping("/pay")
    @ResponseBody
    public ResponseResult pay(String orderId) throws WxErrorException, WxPayException {

        // 模拟数据库下单操作
        // TODO 下单
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();

//        WxPayUnifiedOrderResult wxPayUnifiedOrderResult = wxPayService.unifiedOrder(orderRequest);

        // TODO 返回给前端预支付id
//        String prepayId = wxPayUnifiedOrderResult.getPrepayId();

        return ResponseResult.success().data("msg", "下单ok！");

    }







}