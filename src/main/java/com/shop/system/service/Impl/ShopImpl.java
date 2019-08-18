package com.shop.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.ShopMapper;
import com.shop.system.mapper.UserMapper;
import com.shop.system.model.domain.Shop;
import com.shop.system.model.domain.User;
import com.shop.system.service.ShopService;
import com.shop.system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ShopImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService { }
