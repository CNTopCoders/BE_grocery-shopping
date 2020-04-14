package com.alias.uploadcet.dto;

import lombok.Data;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-12 21:39
 */
@Data
public class BaseResponse<T> {
    public String message;
    public Integer code;
    public T data;
}
