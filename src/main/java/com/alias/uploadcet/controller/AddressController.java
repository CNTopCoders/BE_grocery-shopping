package com.alias.uploadcet.controller;

import com.alias.uploadcet.dto.BaseResponse;
import com.alias.uploadcet.entity.Address;
import com.alias.uploadcet.service.IAddressService;
import com.alias.uploadcet.util.BaseResponseBuilder;
import com.alias.uploadcet.util.TokenUtil;
import com.alias.uploadcet.vo.AddressVo;
import com.alias.uploadcet.vo.ModifyAddressVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-19 21:28
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @PostMapping("/add")
    @ApiOperation("新增收货地址")
    public BaseResponse<Boolean> addAddress(@RequestBody @ApiParam(value = "商品信息") AddressVo addressVo){
        return BaseResponseBuilder.createBaseResponse(addressService.createAddressByVo(addressVo));
    }

    @PostMapping("/modify")
    @ApiOperation("修改收货地址")
    public BaseResponse<Boolean> modifyAddress(@RequestBody @ApiParam(value = "修改商品信息") ModifyAddressVo modifyAddressVo){
        return BaseResponseBuilder.createBaseResponse(addressService.updateAddressByVo(modifyAddressVo));
    }

    @PostMapping("/delete")
    @ApiOperation("删除收货地址")
    public BaseResponse<Boolean> deleteAddress(@RequestBody @ApiParam(value = "商品ID") String addressId){
        return BaseResponseBuilder.createBaseResponse(addressService.removeById(addressId));
    }
    @PostMapping("/detail")
    @ApiOperation("收货地址详情")
    public BaseResponse<Address> detailAddress(@RequestBody @ApiParam(value = "商品ID") String addressId){
        return BaseResponseBuilder.createBaseResponse(addressService.getById(addressId));
    }

    @PostMapping("/list")
    @ApiOperation("列出收货地址")
    public BaseResponse<List<Address>> listAddress(){
        String userId = TokenUtil.getTokenUserId();
        return BaseResponseBuilder.createBaseResponse(addressService.getAddressByUserId(userId));
    }
}
