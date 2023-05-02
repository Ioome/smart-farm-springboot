package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sutton
 * @description 环境
 * @date 2023-05-02
 */
@Data
@ApiModel("环境")
public class FarmEnvironment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 环境温度
     */
    @ApiModelProperty("环境温度")
    private String airTemperature;

    /**
     * 空气湿度
     */
    @ApiModelProperty("空气湿度")
    private String airHumidity;

    /**
     * 湿度状态
     */
    @ApiModelProperty("湿度状态")
    private String brightSunshine;

    /**
     * 土壤温度
     */
    @ApiModelProperty("土壤温度")
    private String soilTemperature;

    /**
     * 土壤湿度
     */
    @ApiModelProperty("土壤湿度")
    private String soilHumidity;

    /**
     * 其它
     */
    @ApiModelProperty("其它")
    private String other;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 手机
     */
    @ApiModelProperty("手机")
    private String phoneNumber;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

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
    private Date deleteTime;

    /**
     * 主环境id
     */
    @ApiModelProperty("主环境id")
    private Long parentId;

    /**
     * 区块
     */
    @ApiModelProperty("区块")
    private Long blockId;

    /**
     * 设备
     */
    @ApiModelProperty("设备")
    private Long equipment;

    public FarmEnvironment () {
    }
}
