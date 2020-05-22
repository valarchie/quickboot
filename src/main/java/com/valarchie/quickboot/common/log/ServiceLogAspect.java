package com.valarchie.quickboot.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
* description: service层日志打印
* @author: valarchie
* on: 2020/5/18
* @email: 343928303@qq.com
*/
@Aspect
@Component
@Slf4j
public class ServiceLogAspect {

    @Pointcut("execution(public * com.valarchie.quickboot.infrastructure.service.*.*(..))")
    public void serviceLog(){}

    @Before("serviceLog()")
    public void deBefore(JoinPoint joinPoint) {

        log.info("service: {} method: {} is executing , parameters: {}",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());

    }

    @AfterReturning(returning = "ret", pointcut = "serviceLog()")
    public void doAfterReturning(Object ret) {
        // service返回数据
        log.info("service finished return: {} ", ret);
    }

    /**
     * 后置通知
     * @param jp
     */
    @AfterThrowing("serviceLog()")
    public void throwss(JoinPoint jp){}

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("serviceLog()")
    public void after(JoinPoint jp){}


}
