package com.shop.system.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterDTO {

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("密码")
    private String password;

}
