package com.alias.uploadcet.service;

import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.Category;
import com.alias.uploadcet.vo.CategoryVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
public interface ICategoryService extends IService<Category> {

    Boolean deleteCategory(String categoryId);

    Boolean createCategoryByVo(CategoryVo categoryVo);

    List<CategoryTree> getAsyncTree(String categoryId);
}
