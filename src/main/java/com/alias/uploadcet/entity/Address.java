package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@TableName("tb_address")
@Data
public class Address extends Model<Address> {

    private static final long serialVersionUID=1L;

    @TableId
    private String addressId;

    private String userId;

    private String mobile;

    private String contactName;

    private Integer defaultAddress;

    private Integer status;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    public static final String ADDRESS_ID = "address_id";

    public static final String USER_ID = "user_id";

    public static final String MOBILE = "mobile";

    public static final String CONTACT_NAME = "contact_name";

    public static final String DEFAULT_ADDRESS = "default_address";

    public static final String STATUS = "status";

    public static final Integer STATUS_NORMAL = 0;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Address{" +
        "addressId=" + addressId +
        ", userId=" + userId +
        ", mobile=" + mobile +
        ", contactName=" + contactName +
        ", defaultAddress=" + defaultAddress +
        ", status=" + status +
        "}";
    }
}
