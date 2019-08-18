package com.shop.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.UserMapper;
import com.shop.system.model.domain.User;
import com.shop.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getPhone(Integer phone) {
        return userMapper.getPhone(phone);
    };
}
