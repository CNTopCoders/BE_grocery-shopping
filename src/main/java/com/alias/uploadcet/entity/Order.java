package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Data
@Entity
@Table(name="tb_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID=1L;

    @TableId
    @Id
    private String orderId;

    private LocalDateTime createTime;

    private Integer status;

    private LocalDateTime expectDeliverTimeStart;

    private LocalDateTime expectDeliverTimeEnd;

    private String deliverAddressId;

    private String deliverAddress;

    private String userId;

    private BigDecimal amount;

    private String comment;


    public static final String ORDER_ID = "order_id";

    public static final String CREATE_TIME = "create_time";

    public static final String STATUS = "status";

    public static final String EXPECT_DELIVER_TIME_START = "expect_deliver_time_start";

    public static final String EXPECT_DELIVER_TIME_END = "expect_deliver_time_end";

    public static final String DELIVER_ADDRESS_ID = "deliver_address_id";

    public static final String DELIVER_ADDRESS = "deliver_address";

    public static final String USER_ID = "user_id";

    public static final String AMOUNT = "amount";

    public static final Integer STATUS_CLOSED = 3;
    public static final Integer STATUS_WAIT_DELIVERY = 1;
    public static final Integer STATUS_IN_DELIVERY = 2;
    public static final Integer STATUS_CANCEL = -1;
    public static final Integer STATUS_NOT_RECEIVED = 0;
    public static final Integer STATUS_DELETED = -2;

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
