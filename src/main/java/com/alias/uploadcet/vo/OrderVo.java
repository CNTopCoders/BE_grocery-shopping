package com.alias.uploadcet.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-17 00:02
 */
@Data
public class OrderVo {

    private LocalDateTime expectDeliverTimeStart;

    private LocalDateTime expectDeliverTimeEnd;

    private String deliverAddressId;

    private String deliverAddress;

    private List<ProductDetail> productDetails;

}
