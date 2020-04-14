package com.alias.uploadcet.exception;

import com.alias.uploadcet.dto.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-13 00:18
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<String> runtimeExceptionHandler(RuntimeException ex) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(-1);
        baseResponse.setMessage(ex.getMessage());
        baseResponse.setData(null);
        return baseResponse;
    }


}