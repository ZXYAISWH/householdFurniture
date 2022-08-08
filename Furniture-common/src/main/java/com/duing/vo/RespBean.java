package com.duing.vo;


import com.duing.enums.resp.ResultCode;
import com.duing.inter.StatusCode;
import lombok.Data;
/**
 * @ Author     :harlon

 * @ Description VO - 统一Http响应结果

 * @ Date       :2022/3/6
*/

@Data
public class RespBean {

    private int code;
    private String msg;
    private Object data;

    /**
     *  手动设置返回Bean
     * */
    public RespBean(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     *  默认返回成功状态码，数据对象
     * */
    public RespBean(Object data){
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     *  返回指定状态码，数据对象
     * */
    public RespBean(StatusCode statusCode, Object data){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }
    /**
     *  只返回状态码
     * */
    public RespBean(StatusCode statusCode){
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }

}
