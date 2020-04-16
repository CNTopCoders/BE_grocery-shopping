package com.alias.uploadcet.service;

import com.alias.uploadcet.entity.Product;
import com.alias.uploadcet.vo.ProductVo;
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
public interface IProductService extends IService<Product> {

    List<Product> getProductByCat(String categoryId, Integer onShelf);

    Boolean insertByVo(ProductVo productVo);

    Boolean modifyByVo(ProductVo productVo);

    Boolean shelfProducts(String[] productIds);

    Boolean offShelfProducts(String[] productIds);
}
