package com.shop.system.model.dto;

import com.shop.system.model.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {
    @ApiModelProperty("验证 token")
    private String token;
    @ApiModelProperty("用户信息")
    private User user;

    public UserDTO (String token, User user) {
        this.token = token;
        this.user = user;
    }
}
