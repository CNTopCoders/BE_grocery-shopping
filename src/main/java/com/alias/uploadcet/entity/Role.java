package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-20 00:09
 */
@Data
@Entity
@TableName("tb_role")
@Table(name="tb_role")
public class Role {
    @TableId
    @Id
    private Integer roleId;

    private String roleName;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public static final Integer ROLE_ID_NORMAL = 1;
    public static final Integer ROLE_ID_ADMIN = 2;
}
