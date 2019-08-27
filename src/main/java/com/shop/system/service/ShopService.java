package com.shop.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.ShopMapper;
import com.shop.system.model.domain.Shop;
import com.shop.system.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService extends EntityService<ShopMapper, Shop> {
    @Autowired
    public ShopMapper shopMapper;

}
