package com.shop.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.system.model.domain.Permission;
import com.shop.system.model.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> getListByRoleId(String id );
}
