package com.alias.uploadcet.entity;

import lombok.Data;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 23:12
 */
@Data
public class DisplayCategory {
    private static final long serialVersionUID=1L;

    private String categoryId;

    private String categoryName;

    private String parentId;

    private Integer sort;

    private Integer leaf;
//    private Integer categoryType;

    private Integer level;
}
