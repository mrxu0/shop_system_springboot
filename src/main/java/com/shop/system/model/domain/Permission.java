package com.shop.system.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shop.system.model.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("permissions")
public class Permission extends Entity {
    @TableField("permission_id")
    @ApiModelProperty("权限 id")
    private Long permissionId;

    @ApiModelProperty("权限名称")
    private String name;

    @ApiModelProperty("权限描述")
    private String des;
}
