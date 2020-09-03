package com.valarchie.quickboot.demo.interfaces.controller;

import com.google.common.eventbus.EventBus;
import com.valarchie.quickboot.core.common.api.ResponseResult;
import com.valarchie.quickboot.core.common.event.EBMessage;
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
@RequestMapping("/eventBus")
public class EventBusController {

    @Autowired
    private EventBus eventBus;

    @RequestMapping("/sendMessage")
    @ResponseBody
    public ResponseResult sendMessage() {

        eventBus.post(new EBMessage("hello valarchie"));

        return ResponseResult.success().data("msg", "发送异步事件成功！");

    }

}