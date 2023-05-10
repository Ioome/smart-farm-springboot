package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.farm.validation.TelephoneNumber;
import com.farm.validation.group.RegisterGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @name: FarmAdmin
 * @author: sutton
 * @date: 2023-04-27 11:39
 * @description: FarmAdmin
 */
@Data
@ApiModel("后台用户表")
@TableName(value = "farm_admin")
public class FarmAdmin implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;

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
     * 密码
     */
    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空", groups = {RegisterGroup.class})
    private String password;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    private Integer status;

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
     * 用户类型（0管理员，1普通用户）
     */
    @ApiModelProperty("用户类型（0管理员，1普通用户）")
    private String userType;

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

    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    private Date loginTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private Integer updateBy;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Integer createBy;

    /**
     * 删除（null.正常)
     */
    @ApiModelProperty("删除（null.正常)")
    @TableLogic
    private Date deleteTime;

    @ApiModelProperty("邮箱修改次数")
    private Long emailCount;

}
