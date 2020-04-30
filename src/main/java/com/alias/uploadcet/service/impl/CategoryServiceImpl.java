package com.alias.uploadcet.service.impl;


import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.Category;
import com.alias.uploadcet.entity.Product;
import com.alias.uploadcet.exception.BaseRuntimeException;
import com.alias.uploadcet.mapper.CategoryMapper;
import com.alias.uploadcet.service.ICategoryService;
import com.alias.uploadcet.service.IProductService;
import com.alias.uploadcet.vo.CategoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
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

    @Autowired
    private IProductService productService;
    @Override
    public Boolean deleteCategory(String categoryId){
        Category category = this.getById(categoryId);
        if(category!=null) {
            QueryWrapper<Product> wrapper = new QueryWrapper<>();
            wrapper.eq(Product.CATEGORY_ID, categoryId);
            productService.remove(wrapper);
            this.removeById(categoryId);
        }
        return true;
    }
    @Override
    public Boolean createCategoryByVo(CategoryVo categoryVo){
        Category category = new Category();
        if(StringUtils.isEmpty(categoryVo.getParentId())){
            category.setLevel(1);
        }else{
            Category parent = this.getById(categoryVo.getParentId());
            if(parent==null){
                throw new BaseRuntimeException("父级类别不存在");
            }
            category.setParentId(categoryVo.getParentId());
            category.setLevel(parent.getLevel()+1);
            parent.setLeaf(false);
            this.updateById(parent);
        }
        //true = 1
        category.setLeaf(true);
        category.setCreateTime(LocalDateTime.now());
        category.setCategoryName(categoryVo.getCategoryName());
        return this.save(category);
//        if(level.equals(CategoryLevelEnum.LEVEL2))
    }

    @Override
    public List<CategoryTree> getAsyncTree(String categoryId){
        if(StringUtils.isEmpty(categoryId)||"null".equals(categoryId)||"0".equals(categoryId)){
            return this.getRootCategory();
        }
        return getChildrenCategory(categoryId);
//        if(level.equals(CategoryLevelEnum.LEVEL2))
    }

    private List<CategoryTree> getRootCategory(){
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.isNull(Category.PARENT_ID);
        wrapper.or().eq(Category.PARENT_ID,"");
        List<Category> categories = this.list(wrapper);
        if(CollectionUtils.isEmpty(categories)){
            return new ArrayList<>();
        }
        return judgeLeafCategoryTrees(categories);
    }

    private List<CategoryTree> judgeLeafCategoryTrees(List<Category> categories) {
        QueryWrapper<Category> wrapper;
        List<CategoryTree> categoryTrees = categories.stream().map(e->convertToCategoryTree(e)).collect(Collectors.toList());
        wrapper = new QueryWrapper<>();
        List<String> parentIds = categories.stream().map(Category::getCategoryId).collect(Collectors.toList());
        wrapper.in(Category.PARENT_ID,parentIds);
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
