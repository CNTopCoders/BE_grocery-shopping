package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@TableName("tb_product")
public class Product extends Model<Product> {

    private static final long serialVersionUID=1L;

    @TableId
    private String productId;

    private String categoryId;

    private String productName;

    private String unit;

    private Integer stock;

    private BigDecimal unitPrice;

    private Integer status;

    private String picUrl;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public static final String PRODUCT_ID = "product_id";

    public static final String CATEGORY_ID = "category_id";

    public static final String PRODUCT_NAME = "product_name";

    public static final String UNIT = "unit";

    public static final String STOCK = "stock";

    public static final String UNIT_PRICE = "unit_price";

    public static final String STATUS = "status";

    public static final String PIC_URL = "pic_url";

//    public static final Integer STATUS_NORMAL = 0;

    public static final Integer STATUS_ON_SHELF = 1;
    public static final Integer STATUS_OFF_SHELF = -1;




    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Product{" +
        "productId=" + productId +
        ", categoryId=" + categoryId +
        ", productName=" + productName +
        ", unit=" + unit +
        ", stock=" + stock +
        ", unitPrice=" + unitPrice +
        ", status=" + status +
        ", picUrl=" + picUrl +
        "}";
    }
}
