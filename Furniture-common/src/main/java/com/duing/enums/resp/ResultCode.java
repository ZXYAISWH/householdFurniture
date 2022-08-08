package com.duing.enums.resp;

import com.duing.inter.StatusCode;
import lombok.Getter;

/**
 * @ Author     :Harlon

 * @ Description 枚举 - 全局HTTP统一响应

 * @ Date       :2022/7/13
*/
@Getter
public enum ResultCode implements StatusCode {

    SUCCESS(1000, "请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "response包装失败");

    private int code;
    private String msg;

    ResultCode (int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
