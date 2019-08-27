package com.shop.system.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    protected M entiryEapper;

    public M getBaseMapper() {
        return this.entiryEapper;
    }
}
