package com.duing.exception;

import com.duing.inter.StatusCode;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException{

    private int code;
    private String msg;

    public APIException (StatusCode statusCode){
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }
}
