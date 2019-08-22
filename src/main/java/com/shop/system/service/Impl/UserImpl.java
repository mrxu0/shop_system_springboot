package com.shop.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.UserMapper;
import com.shop.system.model.EntityWrapper;
import com.shop.system.model.domain.User;
import com.shop.system.model.dto.RegisterDTO;
import com.shop.system.service.UserService;
import com.shop.system.utils.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.shop.system.utils.Arguments.check;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getPhone(String phone) {
        return userMapper.getPhone(phone);
    };

    @Override
    public void register(RegisterDTO registerDTO) throws RuntimeException{
        Integer count = userMapper.selectCount(new QueryWrapper<User>()
                        .eq("user_name", registerDTO.getUserName()));
        check(count == 0, "用户已注册,请不要重复注册");
        check(userMapper.getPhone(registerDTO.getPhone()) == null, "用户已注册,请不要重复注册");
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        user.setUpdateDate(new Date());
        user.setCreatedDate(new Date());
        user.setUserId(IdUtil.generatorId());
        userMapper.insert(user);
    };
}
