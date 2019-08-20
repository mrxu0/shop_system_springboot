package com.shop.system.controller;

import com.shop.system.common.resp.ErrorCode;
import com.shop.system.common.resp.Response;
import com.shop.system.constants.ApiVersion;
import com.shop.system.constants.Urls;
import com.shop.system.model.domain.User;
import com.shop.system.model.dto.PwdLoginDTO;
import com.shop.system.model.dto.UserDTO;
import com.shop.system.service.UserService;
import com.shop.system.utils.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;

@Api("用户 API")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @PostMapping(ApiVersion.API_VERSION_1 + Urls.LOGIN)
    public Response<UserDTO> login(@RequestBody PwdLoginDTO pwdLoginDTO) {
        User newUser = userService.getPhone(pwdLoginDTO.getPhone());
        if (pwdLoginDTO.getPassword().equals(pwdLoginDTO.getPassword())) {
            return new Response(new UserDTO(JWTUtil.sign(pwdLoginDTO.getPhone(), pwdLoginDTO.getPassword()), newUser));
        } else {
            return new Response().setMessage("用户名或密码错误");
        }
    }

    @ApiOperation("注册")
    @PostMapping(ApiVersion.API_VERSION_1 + Urls.REGISTER)
    public Response<UserDTO> register(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return new Response().setMessage("注册成功");
    }

    @ApiOperation("修改密码")
    @PostMapping(ApiVersion.API_VERSION_1 + Urls.CHANGE_PASSWORD)
    public Response<UserDTO> changePassword(@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("oldPassword") String oldPassword) {
        return new Response().setMessage("密码修改成功");
    }

    @ApiIgnore
    @GetMapping("401")
    @ResponseBody
    public Response un401() {
        return new Response().setError(ErrorCode.HTTP_STATUS_401, "授权失败");
    }
}
