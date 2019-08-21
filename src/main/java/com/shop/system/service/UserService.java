package com.shop.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.system.model.domain.User;
import com.shop.system.model.dto.RegisterDTO;

public interface UserService extends IService<User> {
    User getPhone(String phone);

    void register (RegisterDTO registerDTO);
}
