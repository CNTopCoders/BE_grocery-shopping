package com.alias.uploadcet.entity;

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
@TableName("tb_order_detail")
public class OrderDetail extends Model<OrderDetail> {

    private static final long serialVersionUID=1L;

    private String orderId;

    private String itemOriginName;

    private String itemOriginId;

    private String itemUnit;

    private BigDecimal itemUnitPrice;

    private Integer itemCount;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemOriginName() {
        return itemOriginName;
    }

    public void setItemOriginName(String itemOriginName) {
        this.itemOriginName = itemOriginName;
    }

    public String getItemOriginId() {
        return itemOriginId;
    }

    public void setItemOriginId(String itemOriginId) {
        this.itemOriginId = itemOriginId;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public BigDecimal getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(BigDecimal itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public static final String ORDER_ID = "order_id";

    public static final String ITEM_ORIGIN_NAME = "item_origin_name";

    public static final String ITEM_ORIGIN_ID = "item_origin_id";

    public static final String ITEM_UNIT = "item_unit";

    public static final String ITEM_UNIT_PRICE = "item_unit_price";

    public static final String ITEM_COUNT = "item_count";

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
        "orderId=" + orderId +
        ", itemOriginName=" + itemOriginName +
        ", itemOriginId=" + itemOriginId +
        ", itemUnit=" + itemUnit +
        ", itemUnitPrice=" + itemUnitPrice +
        ", itemCount=" + itemCount +
        "}";
    }
}
