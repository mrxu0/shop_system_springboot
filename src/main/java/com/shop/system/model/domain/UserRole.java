package com.shop.system.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shop.system.model.Entity;
import lombok.Data;

@Data
@TableName("users_roles_relation")
public class UserRole extends Entity {
    @TableField("user_id")
    private String userId;
    @TableField("role_id")
    private String roleId;
}
