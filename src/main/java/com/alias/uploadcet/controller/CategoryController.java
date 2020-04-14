package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.entity.Category;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-15 00:04
 */
@RestController
public class CategoryController {

    public BaseResponse<List<Category>> getCategoryTreeAsync(String categoryId,String categoryType){

    }

    public BaseResponse<List<Category>> getDisplayCategory(){

    }
}
