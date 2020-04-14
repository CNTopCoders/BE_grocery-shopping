package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@TableName("tb_address")
public class Address extends Model<Address> {

    private static final long serialVersionUID=1L;

    private String addressId;

    private String userId;

    private String mobile;

    private String contactName;

    private Integer defaultAddress;

    private Integer status;


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Integer defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static final String ADDRESS_ID = "address_id";

    public static final String USER_ID = "user_id";

    public static final String MOBILE = "mobile";

    public static final String CONTACT_NAME = "contact_name";

    public static final String DEFAULT_ADDRESS = "default_address";

    public static final String STATUS = "status";

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
