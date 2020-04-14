package com.alias.uploadcet.util;

import com.alias.uploadcet.dto.BaseResponse;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-12 22:30
 */
public class BaseResponseBuilder {
    public static <T> BaseResponse<T> createBaseResponse(T t){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(0);
        baseResponse.setData(t);
        baseResponse.setMessage("success");
        return baseResponse;
    }
}
