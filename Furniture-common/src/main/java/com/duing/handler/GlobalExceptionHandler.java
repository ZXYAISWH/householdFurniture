package com.duing.handler;

import com.duing.enums.resp.ResultCode;
import com.duing.exception.APIException;
import com.duing.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(APIException.class)
    public RespBean apiExceptionHandler(APIException e){
        return new RespBean(e.getCode(),e.getMsg(),null);
    }

    @ExceptionHandler(BindException.class)
    public RespBean systemExceptionHandler(BindException e){
        // 获取异常对象中的ObjectError
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return new RespBean(ResultCode.VALIDATE_ERROR,error.getDefaultMessage());
    }
}