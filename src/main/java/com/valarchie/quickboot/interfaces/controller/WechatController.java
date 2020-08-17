package com.valarchie.quickboot.interfaces.controller;

import com.google.common.eventbus.EventBus;
import com.valarchie.quickboot.application.common.api.ResponseResult;
import com.valarchie.quickboot.application.common.event.EBMessage;
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
 * description:
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
    public ResponseResult pay(String code) throws WxErrorException {

        WxMpOAuth2AccessToken s = wxOpenService.getWxOpenComponentService().oauth2getAccessToken("s", "");

        WxOpenAuthorizerInfoResult authorizerInfoResult =
                wxOpenService.getWxOpenComponentService().getAuthorizerInfo(s.getAccessToken());

        WxOpenAuthorizerInfo authorizerInfo1 = authorizerInfoResult.getAuthorizerInfo();
        WxOpenAuthorizationInfo authorizationInfo = authorizerInfoResult.getAuthorizationInfo();


        return ResponseResult.success().data("msg", "登陆成功！");

    }

}