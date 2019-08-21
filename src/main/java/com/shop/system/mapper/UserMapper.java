package com.shop.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.system.model.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
    User getPhone(String phone);
}
