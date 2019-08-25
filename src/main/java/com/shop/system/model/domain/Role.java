package com.shop.system.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shop.system.model.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("roles")
public class Role extends Entity {
    @TableField("role_id")
    @ApiModelProperty("角色 id")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色描述")
    private String des;
}
