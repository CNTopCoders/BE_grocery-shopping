package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-15 00:03
 */
@RestController
public class ProductController {

    @GetMapping()
    public BaseResponse<List<Product>> getAllProductByCategory(String categoryId){

    }
}
