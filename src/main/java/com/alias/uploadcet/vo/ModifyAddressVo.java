package com.alias.uploadcet.vo;

import lombok.Data;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-19 21:47
 */
@Data
public class ModifyAddressVo {
    private String addressId;

    private String userId;

    private String mobile;

    private String contactName;

    private Integer defaultAddress;

    private Integer status;
}
