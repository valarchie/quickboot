package com.valarchie.quickboot.common.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 控制器层日志打印
 *
 * @author: valarchie
 * on: 2020/5/18
 * @email: 343928303@qq.com
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    @Pointcut("execution(public * com.valarchie.quickboot.controller.*.*(..))")
    public void webLog() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) {

        // 获取当前请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录详细请求内容
        log.info("request url:{}, method:{}, ip:{}",
                request.getRequestURL().toString(), request.getMethod(), request.getRemoteAddr());

        // 如果是二进制流的话 不打印
        boolean isFile = false;

        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof MultipartFile || arg instanceof MultipartFile[]) {
                isFile = true;
            }
        }

        log.info("controller:{}, function:{}, parameters:{}",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(), isFile ? "file" : JSON.toJSON(joinPoint.getArgs()));


    }

    /**
     * 返回通知
     *
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        log.info("response body：" + JSON.toJSON(ret));
    }

    /**
     * 后置异常通知
     *
     * @param jp
     */
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp) {
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     *
     * @param jp
     */
    @After("webLog()")
    public void after(JoinPoint jp) {
    }


    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     */
//    @Around("webLog()")
//    public Object around(ProceedingJoinPoint pjp) {
//        try {
//            // log
//            Object o = pjp.proceed();
//            // log
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return e;
//        }
//    }

}
