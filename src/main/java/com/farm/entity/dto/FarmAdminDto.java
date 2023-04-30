package com.farm.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @name: FarmAdminDto
 * @author: sutton
 * @date: 2023-04-30 13:09
 * @description: 用户表登录
 */
@Data
public class FarmAdminDto {
    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户状态")
    private Integer status;

    @ApiModelProperty("用户手机号")
    private String phone;

    @ApiModelProperty("用户性别")
    private String sex;

    @ApiModelProperty("用户类型")
    private Integer userType;

    @ApiModelProperty("用户头像")
    private String icon;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户备注")
    private String note;

}
