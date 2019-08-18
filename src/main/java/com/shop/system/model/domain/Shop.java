package com.shop.system.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shop.system.model.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("shops")
@Data
public class Shop extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @TableField("shop_id")
    @ApiModelProperty("商品 id")
    private String shopId;

    @ApiModelProperty("商品名称")
    @TableField("shop_name")
    private String shopName;

    @ApiModelProperty("价格")
    private String price;

    @ApiModelProperty("原价")
    @TableField("original_price")
    private String originalPrice;

    @ApiModelProperty("商品描述")
    private Integer des;

    @ApiModelProperty("显示图片")
    @TableField("show_img")
    private Integer showImg;

    @ApiModelProperty("轮播图片")
    @TableField("swiper_img")
    private Date swiperImg;


}
