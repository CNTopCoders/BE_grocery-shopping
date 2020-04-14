package com.alias.uploadcet.service.impl;

import com.alias.uploadcet.entity.User;
import com.alias.uploadcet.mapper.UserMapper;
import com.alias.uploadcet.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Description :
 * @Author : ZGS
 * @Date: 2020-04-12 17:08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserByOpenId(String openId){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(User.OPEN_ID,openId);
        return this.getOne(wrapper);
    }
}
