package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author www.itgongju.com
 * @description farm_equipment
 * @date 2023-04-28
 */
@Data
@ApiModel("farm_equipment")
public class FarmEquipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 设备名称
     */
    @ApiModelProperty("设备名称")
    private String equipmentName;

    /**
     * 设备编号
     */
    @ApiModelProperty("设备编号")
    private String equipmentNumber;

    /**
     * 设备类型
     */
    @ApiModelProperty("设备类型")
    private String equipmentType;

    /**
     * 设备状态 1 使用 2 弃用
     */
    @ApiModelProperty("设备状态 1 使用 2 弃用")
    private String equipmentStatus;

    /**
     * 设备 1 启动 2 关机
     */
    @ApiModelProperty("设备 1 启动 2 关机")
    private Long status;

    /**
     * 发送时间
     */
    @ApiModelProperty("发送时间")
    private Date sendTime;

    /**
     * 开机时间
     */
    @ApiModelProperty("开机时间")
    private Date startTime;

    /**
     * 关机时间
     */
    @ApiModelProperty("关机时间")
    private Date endTime;

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
     * 客户端ip
     */
    @ApiModelProperty("客户端ip")
    private String clientIp;

    /**
     * 客户端端口
     */
    @ApiModelProperty("客户端端口")
    private String clientPort;

    @ApiModelProperty("通道id")
    private String channelId;

    @ApiModelProperty("数据")
    private String data;
}
