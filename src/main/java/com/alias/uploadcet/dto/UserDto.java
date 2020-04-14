package com.alias.uploadcet.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-13 00:01
 */
@Data
public class UserDto {
    private String userName;
    private String openId;
    private LocalDateTime lastLoginTime;
}
