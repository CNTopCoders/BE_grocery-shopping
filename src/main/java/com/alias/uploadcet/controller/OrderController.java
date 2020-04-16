package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.vo.OrderVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 23:54
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/create")
    public BaseResponse<Boolean> createOrder(OrderVo orderVo){

    }
}
