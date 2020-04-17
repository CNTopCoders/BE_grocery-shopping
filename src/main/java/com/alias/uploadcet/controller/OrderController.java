package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.entity.Order;
import com.alias.uploadcet.service.IOrderService;
import com.alias.uploadcet.util.BaseResponseBuilder;
import com.alias.uploadcet.vo.OrderVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private IOrderService orderService;
    @PostMapping("/create")
    @ApiOperation(value = "创建订单")
    public BaseResponse<Boolean> createOrder(@RequestBody @ApiParam(value = "订单实体") OrderVo orderVo){
        return BaseResponseBuilder.createBaseResponse(orderService.createByVo(orderVo));
    }

    @PostMapping("/beginDelivery")
    public BaseResponse<Boolean> beginDelivery(@RequestBody @ApiParam(value = "订单ID") String orderId){
        Order order = orderService.getById(orderId);
        order.setStatus(Order.STATUS_IN_DELIVERY);
        return BaseResponseBuilder.createBaseResponse(orderService.updateById(order));
    }

    @PostMapping("/finishDelivery")
    public BaseResponse<Boolean> finishDelivery(@RequestBody @ApiParam(value = "订单ID") String orderId){
        Order order = orderService.getById(orderId);
        order.setStatus(Order.STATUS_CLOSED);
        return BaseResponseBuilder.createBaseResponse(orderService.updateById(order));
    }

    @PostMapping("/receive")
    public BaseResponse<Boolean> receiveOrder(@RequestBody @ApiParam(value = "订单ID") String orderId){
        Order order = orderService.getById(orderId);
        order.setStatus(Order.STATUS_WAIT_DELIVERY);
        return BaseResponseBuilder.createBaseResponse(orderService.updateById(order));
    }

    @PostMapping("/cancel")
    public BaseResponse<Boolean> cancelOrder(@RequestBody @ApiParam(value = "订单ID") String orderId){
        Order order = orderService.getById(orderId);
        order.setStatus(Order.STATUS_CANCEL);
        return BaseResponseBuilder.createBaseResponse(orderService.updateById(order));
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteOrder(@RequestBody @ApiParam(value = "订单ID") String orderId){
        Order order = orderService.getById(orderId);
        order.setStatus(Order.STATUS_DELETED);
        return BaseResponseBuilder.createBaseResponse(orderService.updateById(order));
    }

//    @PostMapping("/listRecent")
//    public BaseResponse<Boolean> listOrderByTime(){
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.orderBy(Order.CREATE_TIME,true);
//        List<Order> orders = orderService.list()
//        Order order = orderService.getById(orderId);
//        order.setStatus(Order.STATUS_DELETED);
//        return BaseResponseBuilder.createBaseResponse(orderService.updateById(order));
//    }
}
