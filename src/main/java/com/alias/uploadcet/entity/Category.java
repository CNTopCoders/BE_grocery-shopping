package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@Data
@TableName("tb_category")
public class Category extends Model<Category> {

    private static final long serialVersionUID=1L;

    private String categoryId;

    private String categoryName;

    private String parentId;

    private Integer sort;

    private Integer leaf;
//    private Integer categoryType;

    private Integer level;


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public static final String CATEGORY_ID = "category_id";

    public static final String CATEGORY_NAME = "category_name";

    public static final String PARENT_ID = "parent_id";

    public static final String SORT = "sort";

    public static final String LEAF = "leaf";

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Category{" +
        "categoryId=" + categoryId +
        ", categoryName=" + categoryName +
        ", parentId=" + parentId +
        ", sort=" + sort +
        ", leaf=" + leaf +
        "}";
    }
}
