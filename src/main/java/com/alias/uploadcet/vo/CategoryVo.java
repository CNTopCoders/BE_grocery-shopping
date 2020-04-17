package com.alias.uploadcet.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-18 00:07
 */
@Data
@ApiModel
public class CategoryVo {

    private String categoryName;

    private String parentId;

    private Integer sort;

//    private Integer leaf;
    private Integer categoryType;

}
