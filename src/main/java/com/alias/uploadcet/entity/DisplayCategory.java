package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 23:12
 */
@Data
@Entity
@TableName("tb_display_category")
@Table(name="tb_display_category")
public class DisplayCategory {
    private static final long serialVersionUID=1L;

    @TableId
    @Id
    private String categoryId;

    private String categoryName;

    private String parentId;

    private Integer sort;

    private Integer leaf;
//    private Integer categoryType;

    private Integer level;
}
