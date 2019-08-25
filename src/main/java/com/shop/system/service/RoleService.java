package com.shop.system.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.system.mapper.PermissionMapper;
import com.shop.system.mapper.RoleMapper;
import com.shop.system.model.domain.Permission;
import com.shop.system.model.domain.Role;
import com.shop.system.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {
}
