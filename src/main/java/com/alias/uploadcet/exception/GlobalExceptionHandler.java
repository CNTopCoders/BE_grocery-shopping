package com.alias.uploadcet.exception;

import com.alias.uploadcet.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class GlobalExceptionHandler {

    //运行时异常
    @ExceptionHandler(BaseRuntimeException.class)
    public BaseResponse<String> runtimeExceptionHandler(BaseRuntimeException ex) {
        log.error(ex.getMessage());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(ex.getCode());
        if(baseResponse.getCode() == -1){
            baseResponse.setCode(-1);
        }
        baseResponse.setMessage(ex.getMessage());
        baseResponse.setData(null);
        return baseResponse;
    }
//    @ExceptionHandler(RuntimeException.class)
//    public BaseResponse<String> runtimeExceptionHandler(RuntimeException ex) {
//        log.error(ex.getMessage());
//        BaseResponse baseResponse = new BaseResponse();
//        baseResponse.setCode(-1);
//        baseResponse.setMessage(ex.getMessage());
//        baseResponse.setData(null);
//        return baseResponse;
//    }


}