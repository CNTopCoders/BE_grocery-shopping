package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.dto.CategoryTree;
import com.alias.uploadcet.entity.Category;
import com.alias.uploadcet.enums.CategoryTypeEnum;
import com.alias.uploadcet.service.ICategoryService;
import com.alias.uploadcet.service.IDisplayCategoryService;
import com.alias.uploadcet.util.BaseResponseBuilder;
import com.alias.uploadcet.vo.CategoryVo;
import com.alias.uploadcet.vo.ModifyCategoryVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-15 00:04
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IDisplayCategoryService displayCategoryService;

    @GetMapping("/getTreeAsync")
    @ApiOperation("获取异步树，categoryID不传代表查根层级")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "父级分类ID"),
            @ApiImplicitParam(name = "categoryType", value = "分类类型 1=普通分类 2=展示分类（对应最上面那一排）")
    }
    )
    public BaseResponse<List<CategoryTree>> getCategoryTreeAsync(String categoryId, Integer categoryType){

        if(CategoryTypeEnum.TYPE_DISPLAY.getType().equals(categoryType)){
            return BaseResponseBuilder.createBaseResponse(displayCategoryService.getAllDisplayCategoryTrees());
        }
        return BaseResponseBuilder.createBaseResponse(categoryService.getAsyncTree(categoryId));
    }
    @PostMapping("/input")
    @ApiOperation("录入一个类别")
    public BaseResponse<Boolean> inputCategory(@RequestBody @ApiParam(value = "类别实体",required = true) CategoryVo categoryVo){
        return BaseResponseBuilder.createBaseResponse(categoryService.createCategoryByVo(categoryVo));
    }
    @PostMapping("/delete")
    @ApiOperation("删除一个类别")
    public BaseResponse<Boolean> deleteCategory(@RequestBody @ApiParam(value = "类别ID",required = true) String categoryId){
        return BaseResponseBuilder.createBaseResponse(categoryService.removeById(categoryId));
    }
    @PostMapping("/modify")
    @ApiOperation("修改一个类别")
    public BaseResponse<Boolean> modifyCategory(@RequestBody @ApiParam(value = "修改类别实体",required = true) ModifyCategoryVo modifyCategoryVo){
        Category category = categoryService.getById(modifyCategoryVo.getCategoryId());
        category.setCategoryName(modifyCategoryVo.getCategoryName());
        category.setUpdateTime(LocalDateTime.now());
        return BaseResponseBuilder.createBaseResponse(categoryService.updateById(category));
    }
//    public BaseResponse<List<Category>> getDisplayCategory(){
//
//    }
}
