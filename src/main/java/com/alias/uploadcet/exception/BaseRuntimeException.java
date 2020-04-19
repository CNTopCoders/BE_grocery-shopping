package com.alias.uploadcet.exception;

import com.alias.uploadcet.enums.ErrorCodeEnum;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-19 23:53
 */
public class BaseRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer code;

    public BaseRuntimeException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }
    public BaseRuntimeException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
    public BaseRuntimeException(String msg) {
        super(msg);
        this.code = -1;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
