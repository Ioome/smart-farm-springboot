package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @name: FarmPermission
 * @author: sutton
 * @date: 2023-04-27 22:44
 * @description: FarmPermission
 */
@TableName(value = "farm_permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FarmPermission implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;

    /**
     * 父级权限id
     */
    @ApiModelProperty("父级权限id")
    private Long pid;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 权限标识
     */
    @ApiModelProperty("权限标识")
    private String value;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    @ApiModelProperty("权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;

    /**
     * 前端资源路径
     */
    @ApiModelProperty("前端资源路径")
    private String url;

    /**
     * 组件路径
     */
    @ApiModelProperty("组件路径")
    private String componentUrl;

    /**
     * 启用状态；0->禁用；1->启用
     */
    @ApiModelProperty("启用状态；0->禁用；1->启用")
    private Integer status;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    private String visible;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

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

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
