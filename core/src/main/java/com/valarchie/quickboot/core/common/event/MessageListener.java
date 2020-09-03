package com.valarchie.quickboot.core.common.event;

import com.google.common.eventbus.Subscribe;

/**
 * description: 消息事件
 *
 * @author: valarchie
 * on: 2020/8/10
 * @email: 343928303@qq.com
 */
public class MessageListener {

    @Subscribe
    public void listen(EBMessage message) {
        System.out.println("Event bus receive message:" + message.getMessage());
    }

}