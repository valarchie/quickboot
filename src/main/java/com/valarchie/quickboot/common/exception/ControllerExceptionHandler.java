package com.valarchie.quickboot.common.exception;

import com.valarchie.quickboot.common.api.ResponseResult;
import com.valarchie.quickboot.common.api.ResultCodeEnum;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.xml.ws.Response;
import java.lang.reflect.Field;
import java.util.*;

/**
 * description: 全局控制器异常捕获
 * @author: valarchie
 * on: 2020/5/13
 * @email: 343928303@qq.com
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ResponseResult parameterException(BindException e) {


        // 声明字段名称翻译Map
        Map<String, String> fieldNameMaps = new HashMap<>();
        // 获取参数类的所有字段
        Object target = e.getTarget();
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();
        // 获取字段中注解名称，放入map中
        if (fields.length > 0) {

            for (Field field : fields) {
                ApiParam fieldAnnotation = field.getAnnotation(ApiParam.class);
                if (fieldAnnotation != null) {
                    fieldNameMaps.put(field.getName(), fieldAnnotation.name());
                }
            }

        }


        // 抽取参数绑定错误
        List<FieldError> fieldErrors = e.getFieldErrors();
        // 简单的错误提示
        List<String> simpleErrors = new ArrayList<>();
        // 字段去重Set
        Set<String> errorSet = new HashSet<>();

        for (FieldError fieldError : fieldErrors) {

            String field = fieldError.getField();

            if (errorSet.contains(field)) {
                continue;
            }

            // 放入Set进行去重
            errorSet.add(field);

            // 进行翻译字段名称
            if (fieldNameMaps.get(field) != null) {
                field = fieldNameMaps.get(field);
            }

            String defaultMessage = fieldError.getDefaultMessage();

            String simpleError = field + defaultMessage;

            simpleErrors.add(simpleError);
        }


        return ResponseResult.error(ResultCodeEnum.API_ERROR, simpleErrors.toString());

    }


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseResult runtimeException(Exception e) {

        e.printStackTrace();

        return ResponseResult.error(ResultCodeEnum.API_ERROR);

    }

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseResult handleResourceNotFoundException(NoHandlerFoundException nhre) {


        nhre.printStackTrace();
        return ResponseResult.error(ResultCodeEnum.API_ERROR);
    }



}