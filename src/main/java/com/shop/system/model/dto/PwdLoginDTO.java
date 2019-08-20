package com.shop.system.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("密码登录参数")
public class PwdLoginDTO {

    @ApiModelProperty("手机号")
    private Integer phone;

    @ApiModelProperty("密码")
    private String password;

}
