package com.alias.uploadcet.service.impl;


import com.alias.uploadcet.entity.Product;
import com.alias.uploadcet.mapper.ProductMapper;
import com.alias.uploadcet.service.IProductService;
import com.alias.uploadcet.vo.ProductVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Override
    public List<Product> getProductByCat(String categoryId, Integer status){
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq(Product.CATEGORY_ID,categoryId);
        wrapper.eq(Product.STATUS,status);
        return this.list(wrapper);
    }

    @Override
    public Boolean insertByVo(ProductVo productVo){
        Product product = buildProductByVo(productVo);
        return this.save(product);
    }
    @Override
    public Boolean modifyByVo(ProductVo productVo){
        Product product = buildProductByVo(productVo);
        return this.updateById(product);
    }

    @Override
    public Boolean shelfProducts(String[] productIds){
        List<Product> products = this.listByIds(Arrays.asList(productIds));
        products.forEach(e->e.setStatus(Product.STATUS_ON_SHELF));
        return this.updateBatchById(products);
    }
    @Override
    public Boolean offShelfProducts(String[] productIds){
        List<Product> products = this.listByIds(Arrays.asList(productIds));
        products.forEach(e->e.setStatus(Product.STATUS_OFF_SHELF));
        return this.updateBatchById(products);
    }

    private Product buildProductByVo(ProductVo productVo){
        Product product = new Product();
        BeanUtils.copyProperties(productVo,product);
        if(productVo.isOnShelf()){
            product.setStatus(Product.STATUS_ON_SHELF);
        }else{
            product.setStatus(Product.STATUS_OFF_SHELF);
        }
//        product.setUnitPrice(product.getUnitPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
        return product;
    }

//    @Override
//    public Boolean addStock(Integer count,Product product){
//        product.setStock();
//
//    }
//    @Override
//    public Boolean minusStock(Integer count,Product product){
//
//    }
}
