package com.shop.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Entity{

    @ApiModelProperty("状态:0 删除，1 正常")
    private Integer status;

    @ApiModelProperty("创建日期")
    @TableField("created_date")
    private Date createdDate;

    @TableField("update_date")
    @ApiModelProperty("更新日期")
    private Date updateDate;
}
