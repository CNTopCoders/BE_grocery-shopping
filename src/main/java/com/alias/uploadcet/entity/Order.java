package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@TableName("tb_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID=1L;

    private String orderId;

    private LocalDateTime createTime;

    private Integer status;

    private LocalDateTime expectDeliverTimeStart;

    private LocalDateTime expectDeliverTimeEnd;

    private String deliverAddressId;

    private String deliverAddress;

    private String userId;

    private BigDecimal amount;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getExpectDeliverTimeStart() {
        return expectDeliverTimeStart;
    }

    public void setExpectDeliverTimeStart(LocalDateTime expectDeliverTimeStart) {
        this.expectDeliverTimeStart = expectDeliverTimeStart;
    }

    public LocalDateTime getExpectDeliverTimeEnd() {
        return expectDeliverTimeEnd;
    }

    public void setExpectDeliverTimeEnd(LocalDateTime expectDeliverTimeEnd) {
        this.expectDeliverTimeEnd = expectDeliverTimeEnd;
    }

    public String getDeliverAddressId() {
        return deliverAddressId;
    }

    public void setDeliverAddressId(String deliverAddressId) {
        this.deliverAddressId = deliverAddressId;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static final String ORDER_ID = "order_id";

    public static final String CREATE_TIME = "create_time";

    public static final String STATUS = "status";

    public static final String EXPECT_DELIVER_TIME_START = "expect_deliver_time_start";

    public static final String EXPECT_DELIVER_TIME_END = "expect_deliver_time_end";

    public static final String DELIVER_ADDRESS_ID = "deliver_address_id";

    public static final String DELIVER_ADDRESS = "deliver_address";

    public static final String USER_ID = "user_id";

    public static final String AMOUNT = "amount";

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Order{" +
        "orderId=" + orderId +
        ", createTime=" + createTime +
        ", status=" + status +
        ", expectDeliverTimeStart=" + expectDeliverTimeStart +
        ", expectDeliverTimeEnd=" + expectDeliverTimeEnd +
        ", deliverAddressId=" + deliverAddressId +
        ", deliverAddress=" + deliverAddress +
        ", userId=" + userId +
        ", amount=" + amount +
        "}";
    }
}
