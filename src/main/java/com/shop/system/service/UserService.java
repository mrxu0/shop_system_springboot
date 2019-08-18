package com.shop.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.system.model.domain.User;

public interface UserService extends IService<User> {
    User getPhone(Integer phone);
}
