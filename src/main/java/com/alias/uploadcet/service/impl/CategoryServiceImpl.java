package com.alias.uploadcet.service.impl;


import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.Category;
import com.alias.uploadcet.mapper.CategoryMapper;
import com.alias.uploadcet.service.ICategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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


    @Override
    public List<CategoryTree> getAsyncTree(String categoryId){
        if("".equals(categoryId)){
            return this.getRootCategory();
        }
        return getChildrenCategory(categoryId);
//        if(level.equals(CategoryLevelEnum.LEVEL2))
    }

    private List<CategoryTree> getRootCategory(){
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        List<Category> categories = this.list(wrapper.isNull(Category.PARENT_ID));
        return judgeLeafCategoryTrees(categories);
    }

    private List<CategoryTree> judgeLeafCategoryTrees(List<Category> categories) {
        QueryWrapper<Category> wrapper;
        List<CategoryTree> categoryTrees = categories.stream().map(e->convertToCategoryTree(e)).collect(Collectors.toList());
        wrapper = new QueryWrapper<>();
        wrapper.in(Category.PARENT_ID,categories.stream().map(Category::getCategoryId).collect(Collectors.toList()));
        List<Category> childrenList = this.list(wrapper);
        Set<String> childrenIds = childrenList.stream().map(e->e.getCategoryId()).collect(Collectors.toSet());
        Map<String,Category> childMap = new HashMap<>();
        categoryTrees.forEach(e->{
            if(childrenIds.contains(e.getCategoryId())){
                e.setLeaf(false);
            }
        });
        return categoryTrees;
    }

    private List<CategoryTree> getChildrenCategory(String parentId){
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        List<Category> categories = this.list(wrapper.eq(Category.PARENT_ID,parentId));
        return judgeLeafCategoryTrees(categories);
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