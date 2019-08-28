package com.shop.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.RoleMapper;
import com.shop.system.mapper.UserMapper;
import com.shop.system.model.domain.User;
import com.shop.system.model.dto.RegisterDTO;
import com.shop.system.utils.IdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.shop.system.utils.Arguments.check;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    UserMapper userMapper;

    public User getPhone(String phone) {
        return userMapper.getPhone(phone);
    };

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
