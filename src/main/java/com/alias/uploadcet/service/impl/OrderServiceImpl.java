package com.alias.uploadcet.service.impl;


import com.alias.uploadcet.entity.Order;
import com.alias.uploadcet.entity.OrderDetail;
import com.alias.uploadcet.entity.Product;
import com.alias.uploadcet.mapper.OrderMapper;
import com.alias.uploadcet.service.IOrderDetailService;
import com.alias.uploadcet.service.IOrderService;
import com.alias.uploadcet.service.IProductService;
import com.alias.uploadcet.util.TokenUtil;
import com.alias.uploadcet.vo.OrderVo;
import com.alias.uploadcet.vo.ProductDetail;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private IProductService productService;

    @Override
    public Boolean createByVo(OrderVo orderVo){
        Order order = new Order();
        BeanUtils.copyProperties(orderVo,order);
        order.setStatus(Order.STATUS_NOT_RECEIVED);
        order.setCreateTime(LocalDateTime.now());
        order.setUserId(TokenUtil.getTokenUserId());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        order.setExpectDeliverTimeStart(LocalDateTime.parse(orderVo.getExpectDeliverTimeStart(),df));
        order.setExpectDeliverTimeEnd(LocalDateTime.parse(orderVo.getExpectDeliverTimeStart(),df));

        List<ProductDetail> productDetails = orderVo.getProductDetails();
        List<OrderDetail> orderDetails = new ArrayList<>();
        BigDecimal amount = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
        for(ProductDetail productDetail:productDetails) {
                Product product = productService.getById(productDetail.getProductId());
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setItemCount(productDetail.getCount());
                orderDetail.setItemOriginId(product.getProductId());
                orderDetail.setItemOriginName(product.getProductName());
                orderDetail.setItemUnit(product.getUnit());
                orderDetail.setItemUnitPrice(product.getUnitPrice());
                orderDetails.add(orderDetail);
                if(product.getStock() - productDetail.getCount() < 0){
                    return false;
                }
                product.setStock(product.getStock() - productDetail.getCount());
                amount = amount.add(product.getUnitPrice().multiply(new BigDecimal(productDetail.getCount())));
                productService.updateById(product);
//                amount = amount + product.getUnitPrice()
        }
        order.setAmount(amount);
        this.save(order);
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderId(order.getOrderId());
        }
        this.updateById(order);
        return orderDetailService.saveBatch(orderDetails);
    }


}
