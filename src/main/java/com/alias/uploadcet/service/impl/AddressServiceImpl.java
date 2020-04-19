package com.alias.uploadcet.service.impl;

import com.alias.uploadcet.entity.Address;
import com.alias.uploadcet.mapper.AddressMapper;
import com.alias.uploadcet.service.IAddressService;
import com.alias.uploadcet.vo.AddressVo;
import com.alias.uploadcet.vo.ModifyAddressVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {


    @Override
    public Boolean createAddressByVo(AddressVo addressVo){
        Address address = new Address();
        address.setStatus(Address.STATUS_NORMAL);
        BeanUtils.copyProperties(addressVo,address);
        return this.save(address);
    }

    @Override
    public Boolean updateAddressByVo(ModifyAddressVo modifyAddressVo){
        Address address = this.getById(modifyAddressVo.getAddressId());
        if(address!=null){
            BeanUtils.copyProperties(modifyAddressVo,address);
            return this.save(address);
        }else{
            throw new RuntimeException("不存在该收货地址");
        }
    }

}
