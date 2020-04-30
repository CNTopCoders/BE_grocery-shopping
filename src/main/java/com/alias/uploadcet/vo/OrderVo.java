package com.alias.uploadcet.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-17 00:02
 */
@Data
@ApiModel
public class OrderVo {

    @ApiModelProperty(value = "期望配送时间段开始 格式yyyy-MM-dd HH:mm:ss")
    private String expectDeliverTimeStart;
    @ApiModelProperty(value = "期望配送时间段结束 格式yyyy-MM-dd HH:mm:ss")
    private String expectDeliverTimeEnd;

//    @ApiModelProperty(value = "期望配送时间段 格式yyyy-MM-dd HH:mm:ss")
//    private String expectDeliverTimeEnd;

    private String deliverAddressId;

    private String deliverAddress;

    private List<ProductDetail> productDetails;

    private String comment;

}
