package com.shop.system.controller;

import com.shop.system.constants.ApiVersion;
import com.shop.system.constants.Urls;
import com.shop.system.model.domain.Permission;
import com.shop.system.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class ShiroController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private PermissionService permissionService;

    @GetMapping(ApiVersion.API_VERSION_1 + Urls.SHIRO_RELOAD)
    public String reloadPermission() {
        // 将系统中所有权限表达式加入数据库
        // 0. 从数据库中查询出来所有的权限表达式，然后对比，如果已经存在了，跳过，不存在添加
        List<String> plist =  permissionService.listName();
        // 1. 获取所有 controller 中带有 RequestMapping 标签的方法
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        Collection<HandlerMethod> methods = map.values();
        for (HandlerMethod method : methods) {
            // 2. 遍历所有方法，判断当前方法是否有 @RequiresPermissions 权限标签
            RequiresPermissions anno = method.getMethodAnnotation(RequiresPermissions.class);
            if (anno != null) {
                String resource = anno.value()[0];
                if (plist.contains(resource)) {
                    continue;
                };
                Permission p = new Permission();
                p.setName(resource);
                p.setDes(method.getMethodAnnotation(ApiOperation.class).value());
                permissionService.saveP(p);
            }
        }
        return "123";
    }

    @GetMapping("shiro/a")
    public List<String> shiroa() {
        return permissionService.getListByRoleId("123");
    }

}
