package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Andy
 * @Date: 2020/11/24 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public static CommonResult successCommonResult(String message,Object obj) {
        return new CommonResult(Code.OK.getCode(),message,obj);
    }

    public static CommonResult errorCommonResult(String message,Object obj) {
        return new CommonResult(Code.ERROR.getCode(),message,obj);
    }

    enum Code {
        OK(200),ERROR(400);
        private Integer statusCode;
        Code(Integer statusNum) {
            this.statusCode = statusNum;
        }

        public Integer getCode() {
            return statusCode;
        }
    }

}
