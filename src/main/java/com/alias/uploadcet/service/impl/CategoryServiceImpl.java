package com.alias.uploadcet.service.impl;


import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.Category;
import com.alias.uploadcet.mapper.CategoryMapper;
import com.alias.uploadcet.service.ICategoryService;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {


    public List<CategoryTree> getAsyncTree(String categoryId,String level){
        if("".equals(categoryId)){

            return this.list(null);
        }
    }

    private List<CategoryTree> getRootCategory(){
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        List<Category> categories = this.list(wrapper.isNull(Category.PARENT_ID));
        wrapper = new QueryWrapper<>();
        wrapper.eq()
        List<Category> childrenList = this.

    }

    private CategoryTree convertToCategoryTree(Category category){
        CategoryTree categoryTree = new CategoryTree();
        categoryTree.setCategoryId(category.getCategoryId());
        categoryTree.setCategoryName(category.getCategoryName());
        categoryTree.setLevel(category.getLevel());
        categoryTree.setLeaf(true);
        categoryTree.setParentId(category.getParentId());
        return categoryTree;
//        categoryTree.setCategoryType(category.getCategoryType());
    }
}
