package com.valarchie.quickboot.infrastructure.service.impl;


import com.valarchie.quickboot.infrastructure.service.AsynService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

/**
 * description:
 *
 * @author: valarchie
 * on: 2020/5/18
 * @email: 343928303@qq.com
 */
@Slf4j
public class AsynServiceImpl implements AsynService {

    @Override
    @Async("asyncServiceExecutor")
    public void asynMethod(String who) {

        try {

            log.info("current thread : {} is running", Thread.currentThread().getName());

            System.out.println(who + " is sleeping");
            // 睡眠五秒 模拟异步操作
            Thread.sleep(5000);
            System.out.println(who + " is wake up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}