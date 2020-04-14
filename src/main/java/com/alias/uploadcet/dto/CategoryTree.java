package com.alias.uploadcet.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-15 00:09
 */
@Data
public class CategoryTree {

    private String categoryId;
    private Integer level;
//    private String categoryType;
    private String categoryName;
    private List<CategoryTree> children;
    private Boolean leaf;
    private String parentId;
}
