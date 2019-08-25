package com.shop.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.PermissionMapper;
import com.shop.system.mapper.ShopMapper;
import com.shop.system.mapper.UserMapper;
import com.shop.system.model.domain.Permission;
import com.shop.system.model.domain.Shop;
import com.shop.system.model.domain.User;
import com.shop.system.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> {
    @Autowired
    public PermissionMapper permissionMapper;

    public void saveP(Permission permission) {
        permission.setStatus(1);
        permission.setUpdateDate(new Date());
        permission.setCreatedDate(new Date());
        permission.setPermissionId(IdUtil.generatorId());
        permissionMapper.insert(permission);
    }

    public List<String> listName() {
        List<Permission> list = this.list();
        List<String> s = new ArrayList<>();
        for(Permission p : list) {
            s.add(p.getName());
        }
        return s;
    }

    public List <String> getListByRoleId(String roleId) {
        return permissionMapper.getListByRoleId(roleId);
    }

}
