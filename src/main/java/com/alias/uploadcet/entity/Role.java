package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-20 00:09
 */
@Data
public class Role {
    @TableId
    private Integer roleId;

    private String roleName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
