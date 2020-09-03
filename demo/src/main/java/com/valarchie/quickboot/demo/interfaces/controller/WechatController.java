package com.valarchie.quickboot.demo.interfaces.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.valarchie.quickboot.core.common.api.ResponseResult;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.bean.auth.WxOpenAuthorizationInfo;
import me.chanjar.weixin.open.bean.auth.WxOpenAuthorizerInfo;
import me.chanjar.weixin.open.bean.result.WxOpenAuthorizerInfoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: 微信相关操作
 *
 * @author: valarchie
 * on: 2020/8/10
 * @email: 343928303@qq.com
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WxOpenService wxOpenService;

    @Autowired
    private WxPayService wxPayService;

    @RequestMapping("/login")
    @ResponseBody
    public ResponseResult login(String code) throws WxErrorException {

        WxMpOAuth2AccessToken s = wxOpenService.getWxOpenComponentService().oauth2getAccessToken("s", "");

        WxOpenAuthorizerInfoResult authorizerInfoResult =
                wxOpenService.getWxOpenComponentService().getAuthorizerInfo(s.getAccessToken());

        WxOpenAuthorizerInfo authorizerInfo1 = authorizerInfoResult.getAuthorizerInfo();
        WxOpenAuthorizationInfo authorizationInfo = authorizerInfoResult.getAuthorizationInfo();


        return ResponseResult.success().data("msg", "登陆成功！");

    }


    @RequestMapping("/pay")
    @ResponseBody
    public ResponseResult pay(String orderId) throws WxPayException {

        // 模拟数据库下单操作
        // TODO 下单
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();

        WxPayUnifiedOrderResult wxPayUnifiedOrderResult = wxPayService.unifiedOrder(orderRequest);

        // TODO 返回给前端预支付id
        String prepayId = wxPayUnifiedOrderResult.getPrepayId();

        return ResponseResult.success().data("msg", "下单ok！");

    }


    @RequestMapping("/payCallBack")
    @ResponseBody
    public ResponseResult payCallBack(String xmlData) throws WxErrorException, WxPayException {

        final WxPayOrderNotifyResult notifyResult = this.wxPayService.parseOrderNotifyResult(xmlData);

        // TODO 根据支付返回结果 去写订单结果

        return ResponseResult.success().data("msg", "支付ok！");

    }

}