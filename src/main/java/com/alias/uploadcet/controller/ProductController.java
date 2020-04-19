package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.entity.Product;
import com.alias.uploadcet.service.IProductService;
import com.alias.uploadcet.util.BaseResponseBuilder;
import com.alias.uploadcet.vo.ModifyProductVo;
import com.alias.uploadcet.vo.ProductVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-15 00:03
 */
@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
private IProductService productService;
    @ApiOperation("根据分类获取商品列表")
    @GetMapping("/listByCategory")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "categoryId", value = "分类ID"),
//            @ApiImplicitParam(name = "status", value = "商品状态 1=上架 -1=下架")
//    }
//    )
    public BaseResponse<List<Product>> getProductByCategory(@RequestParam @ApiParam String categoryId,@RequestParam @ApiParam Integer status){
        return BaseResponseBuilder.createBaseResponse(productService.getProductByCat(categoryId,status));
    }

    @ApiOperation("录入单个商品")
    @PostMapping("/input")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "productVo", value = "商品信息",dataType = "Model(com.alias.uploadcet.vo.ProductVo)"),
//    }
//    )
    public BaseResponse<Boolean> inputProduct(@RequestBody @ApiParam(value = "商品信息", required = true) ProductVo productVo){
        return BaseResponseBuilder.createBaseResponse(productService.insertByVo(productVo));
    }
    @PostMapping("deleteOne")
    @ApiOperation("删除单个商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "productId", value = "商品Id"),
//    })
    public BaseResponse<Boolean> deleteOne(@RequestBody @ApiParam(value = "商品Id") String productId){
        return BaseResponseBuilder.createBaseResponse(productService.removeById(productId));
    }

    @PostMapping("deleteMulti")
    @ApiOperation("删除多个商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "productIds", value = "商品Id集合"),
//    })
    public BaseResponse<Boolean> deleteMulti(@RequestParam @ApiParam(value = "商品Id集合") String[] productIds){
        return BaseResponseBuilder.createBaseResponse(productService.removeByIds(Arrays.asList(productIds)));
    }

    @PostMapping("detail")
    @ApiOperation("查看商品详情")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "productId", value = "商品Id"),
//    })
    public BaseResponse<Product> detail(@RequestParam @ApiParam(value = "商品Id") String productId){
        return BaseResponseBuilder.createBaseResponse(productService.getById(productId));
    }

    @PostMapping("/modify")
    @ApiOperation("修改单个商品")
    public BaseResponse<Boolean> modifyProduct(@RequestBody @ApiParam(value = "商品信息") ModifyProductVo modifyProductVo){
        Product product = productService.getById(modifyProductVo.getProductId());
        if(product==null){
            throw new RuntimeException("商品不存在");
        }
        BeanUtils.copyProperties(modifyProductVo,product);
        return BaseResponseBuilder.createBaseResponse(productService.updateById(product));
    }

    @PostMapping("/onShelf")
    @ApiOperation("批量上架商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "productIds", value = "商品ID集合"),
//    })
    public BaseResponse<Boolean> shelfProduct(@RequestBody @ApiParam(value = "商品ID集合") String[] productIds){
        return BaseResponseBuilder.createBaseResponse(productService.shelfProducts(productIds));
    }

    @PostMapping("/offShelf")
    @ApiOperation("批量下架商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "productIds", value = "商品ID集合"),
//    })
    public BaseResponse<Boolean> offShelfProduct(@RequestBody @ApiParam(value = "商品ID集合") String[] productIds){
        return BaseResponseBuilder.createBaseResponse(productService.offShelfProducts(productIds));
    }

//    @GetMapping("/checkStock")
//    public BaseResponse<Map<String,Integer>>
}
