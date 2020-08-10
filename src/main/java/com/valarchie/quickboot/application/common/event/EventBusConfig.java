package com.valarchie.quickboot.application.common.event;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* description: guava事件处理器
* @author: valarchie
* on: 2020/8/10
* @email: 343928303@qq.com
*/
@Configuration
@Slf4j
public class EventBusConfig {

    @Bean
    public EventBus eventBus() {

        EventBus eventBus = new EventBus("message event processor");

        eventBus.register(new MessageListener());

        return eventBus;

    }


}