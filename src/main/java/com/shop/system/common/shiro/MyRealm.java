package com.shop.system.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shop.system.mapper.PermissionMapper;
import com.shop.system.model.domain.Role;
import com.shop.system.model.domain.User;
import com.shop.system.service.RoleService;
import com.shop.system.service.UserService;
import com.shop.system.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionMapper permissionMapper;



    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     * 这个方法不写在验证 token 的时候会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 授权
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     * PrincipalCollection 用户的凭证信息
     * return AuthorizationInfo 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String phone = JWTUtil.getPhone(principals.toString());
        User user = userService.getPhone(phone);
        if (user != null) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//            List<String> roles = new ArrayList<String>();
//            roles.add("admin");

            List<String> permission = new ArrayList<String>();
            permission.add("shop:add");
            permission.add("shop:list");
            simpleAuthorizationInfo.addStringPermissions(permission);
            return simpleAuthorizationInfo;
        } else {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            List<String> roles = new ArrayList<String>();
            roles.add("tour");
            Role role = roleService.getOne(new QueryWrapper<Role>().eq("name", "tour"));
            List<String> ps = permissionMapper.getListByRoleId(role.getRoleId());
            simpleAuthorizationInfo.addStringPermissions(ps);
            return simpleAuthorizationInfo;
        }

//        return null;
    }

    /**
     * 认证 / 验证
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        if(token == "authorization") {
            return new SimpleAuthenticationInfo(token, token, "my_realm");
        }
        // 解密获得username，用于和数据库进行对比
        String phone = JWTUtil.getPhone(token);
        if (phone == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = userService.getPhone(phone);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, phone, user.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
