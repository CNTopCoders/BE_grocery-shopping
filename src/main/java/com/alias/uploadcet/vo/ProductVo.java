package com.alias.uploadcet.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 23:22
 */
@Data
public class ProductVo {

    private String productId;

    private String categoryId;

    private String productName;

    private String unit;

    private Integer stock;

    private BigDecimal unitPrice;

    private String picUrl;

    private boolean onShelf;
}
