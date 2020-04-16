package com.alias.uploadcet.service.impl;

import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.DisplayCategory;
import com.alias.uploadcet.mapper.DisplayCategoryMapper;
import com.alias.uploadcet.service.IDisplayCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-16 23:13
 */
@Service
public class DisplayCategoryServiceImpl extends ServiceImpl<DisplayCategoryMapper,DisplayCategory> implements IDisplayCategoryService {
    @Override
    public List<CategoryTree> getAllDisplayCategoryTrees(){
        List<DisplayCategory> displayCategories = this.list();
        return displayCategories.stream().map(this::convertToCategoryTree).collect(Collectors.toList());
    }

    private CategoryTree convertToCategoryTree(DisplayCategory category){
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
