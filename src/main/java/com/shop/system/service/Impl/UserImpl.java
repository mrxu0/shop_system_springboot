package com.shop.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.UserMapper;
import com.shop.system.model.domain.User;
import com.shop.system.model.dto.RegisterDTO;
import com.shop.system.service.UserService;
import com.shop.system.utils.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getPhone(String phone) {
        return userMapper.getPhone(phone);
    };

    @Override
    public void register(RegisterDTO registerDTO) {
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        user.setUpdateDate(new Date());
        user.setCreatedDate(new Date());
        user.setUserId(IdUtil.generatorId());
        userMapper.insert(user);
    };
}
