package com.alias.uploadcet.service;

import com.alias.uploadcet.entity.Address;
import com.alias.uploadcet.vo.AddressVo;
import com.alias.uploadcet.vo.ModifyAddressVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author auto-genergator
 * @since 2020-04-14
 */
public interface IAddressService extends IService<Address> {

    Boolean createAddressByVo(AddressVo addressVo);

    Boolean updateAddressByVo(ModifyAddressVo modifyAddressVo);
}
