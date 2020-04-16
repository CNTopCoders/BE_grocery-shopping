package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.enums.CategoryTypeEnum;
import com.alias.uploadcet.service.ICategoryService;
import com.alias.uploadcet.service.IDisplayCategoryService;
import com.alias.uploadcet.util.BaseResponseBuilder;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-15 00:04
 */
@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IDisplayCategoryService displayCategoryService;

    @ApiOperation("获取异步树，categoryID不传代表查根层级")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "父级分类ID"),
            @ApiImplicitParam(name = "categoryType", value = "分类类型 1=普通分类 2=展示分类（对应最上面那一排）")
    }
    )
    public BaseResponse<List<CategoryTree>> getCategoryTreeAsync(String categoryId, String categoryType){

        if(CategoryTypeEnum.TYPE_DISPLAY.equals(categoryType)){
            return BaseResponseBuilder.createBaseResponse(displayCategoryService.getAllDisplayCategoryTrees());
        }
        return BaseResponseBuilder.createBaseResponse(categoryService.getAsyncTree(categoryId));
    }

//    public BaseResponse<List<Category>> getDisplayCategory(){
//
//    }
}
