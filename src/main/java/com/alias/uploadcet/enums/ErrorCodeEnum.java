package com.alias.uploadcet.enums;

import lombok.Getter;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-19 23:37
 */
@Getter
public enum ErrorCodeEnum {
    ERROR_CODE_LOGIN_EXPIRE("登录状态失效，请重新登录",500403);
    private String message;
    private Integer code;
    ErrorCodeEnum(String message, Integer code){
        this.message = message;
        this.code = code;
    }
}
