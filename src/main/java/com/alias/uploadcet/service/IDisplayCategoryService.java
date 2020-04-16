package com.alias.uploadcet.service;

import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.DisplayCategory;
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
public interface IDisplayCategoryService extends IService<DisplayCategory> {

    List<CategoryTree> getAllDisplayCategoryTrees();
}
