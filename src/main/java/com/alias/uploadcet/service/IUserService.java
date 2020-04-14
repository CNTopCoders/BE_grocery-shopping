package com.alias.uploadcet.service;

import com.alias.uploadcet.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description : 用户Sservice
 * @Author : ZGS
 * @Date: 2020-04-12 17:07
 */
public interface IUserService extends IService<User> {
    User getUserByOpenId(String openId);
}
