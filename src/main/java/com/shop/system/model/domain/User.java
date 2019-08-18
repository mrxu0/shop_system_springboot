package com.shop.system.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shop.system.model.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@TableName("users")
@Data
public class User extends Entity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @TableField("user_id")
    @ApiModelProperty("用户 id")
    private String userId;

    @TableField("user_name")
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    @Length(min = 6, max = 20, message = "输入的长度不合法，应在 6-20 之间")
    private String password;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("性别：1男，2女，3保密")
    private Integer gender;

    @ApiModelProperty("年龄")
    @Size(max = 150, min = 0, message = "请输入合法的年龄")
    private Integer age;

    @ApiModelProperty("出生日期")
    @TableField("brith_day")
    @Past(message = "请输入过去日期")
    private Date brithDay;

    @ApiModelProperty("电话")
    @Length(min = 11, max = 11, message = "长度为 11 为")
    private Integer phone;

}
