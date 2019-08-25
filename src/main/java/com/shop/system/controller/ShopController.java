package com.shop.system.controller;

import com.shop.system.common.resp.Response;
import com.shop.system.constants.ApiVersion;
import com.shop.system.constants.Urls;
import com.shop.system.model.domain.Shop;
import com.shop.system.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api("商品 API")
@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @ApiOperation("商品列表")
    @RequiresPermissions("shop:list")
    @GetMapping(ApiVersion.API_VERSION_1 + Urls.SHOPS)
    public Response<List<Shop>> shops() {
        return new Response(shopService.list());
    }

    @RequiresPermissions("shop:add")
    @ApiOperation("添加商品")
    @PostMapping(ApiVersion.API_VERSION_1 + Urls.SHOPS)
    public Response addShop(@Valid @RequestBody Shop shop) {
        return new Response().setMessage("添加成功");
    }

    @ApiOperation("修改商品")
    @RequiresPermissions("shop:edit")
    @PutMapping(ApiVersion.API_VERSION_1 + Urls.SHOP)
    public Response changeShop(@PathVariable String id, @Valid @RequestBody Shop shop) {
        return new Response().setMessage("修改成功");
    }

    @ApiOperation("删除商品")
    @RequiresPermissions("shop:delete")
    @DeleteMapping(ApiVersion.API_VERSION_1 + Urls.SHOP)
    public Response deleteShop(@PathVariable String id) {
        return new Response().setMessage("删除成功");
    }
}
