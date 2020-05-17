package com.valarchie.quickboot.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性名注解，用于前端参数校验给出准确值
 *
 * @Author valarchie
 * @Date 2020-05-17 11:15
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldName {

    String name() default "未命名的字段";

}
