package com.farm.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.farm.validation.TelephoneNumber;
import com.farm.validation.group.RegisterGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @name: FarmAdminVo
 * @author: sutton
 * @date: 2023-05-02 17:11
 * @description: FarmAdminVo
 */
@Data
public class FarmAdminVo {

    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空", groups = {RegisterGroup.class})
    private String username;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;


    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @TelephoneNumber(message = "手机号格式不正确", groups = {RegisterGroup.class})
    @NotEmpty(message = "手机号不能为空", groups = {RegisterGroup.class})
    private String phone;

    /**
     * 用户性别（0男，1女，2未知）
     */
    @ApiModelProperty("用户性别（0男，1女，2未知）")
    private String sex;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String icon;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @NotEmpty(message = "邮箱不能为空", groups = {RegisterGroup.class})
    @Email(message = "邮箱格式不正确", groups = {RegisterGroup.class})
    private String email;


    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String note;
}
