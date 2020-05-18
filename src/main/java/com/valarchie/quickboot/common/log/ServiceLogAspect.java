package com.valarchie.quickboot.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@Slf4j
public class ServiceLogAspect {

    @Pointcut("execution(public * com.valarchie.quickboot.service.*.*(..))")
    public void serviceLog(){}

    @Before("serviceLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        log.debug("service: {} method: {} is executing , parameters: {}",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(), joinPoint.getArgs());

    }

    @AfterReturning(returning = "ret", pointcut = "serviceLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("ssssssss");
        log.debug("方法的返回值 : " + ret);
    }

    //后置异常通知
    @AfterThrowing("serviceLog()")
    public void throwss(JoinPoint jp){
        log.debug("方法异常时执行.....");
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("serviceLog()")
    public void after(JoinPoint jp){
        log.debug("方法最后执行.....");
    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("serviceLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        log.debug("方法环绕start.....");
        try {
            Object o =  pjp.proceed();
            log.debug("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}
