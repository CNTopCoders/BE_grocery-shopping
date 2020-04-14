package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-04-12
 */
@Data
@TableName("tb_user")
public class User {

    private static final long serialVersionUID = 1L;
    @TableId
    private String userId;

    private String userName;

    private String password;

    private String openId;

    private LocalDateTime lastLoginTime;

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String OPEN_ID = "open_id";
    public static final String LAST_LOGIN_TIME = "last_login_time";

}
