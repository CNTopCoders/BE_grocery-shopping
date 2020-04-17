package com.alias.uploadcet.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    @TableId
    private String categoryId;

    private String categoryName;

    private String parentId;

    private Integer sort;

    private Boolean leaf;
    private Integer categoryType;

    private Integer level;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;


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
