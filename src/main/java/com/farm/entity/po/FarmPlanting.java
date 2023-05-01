package com.farm.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
/**
* @description 种植计划表
* @author www.itgongju.com
* @date 2023-05-01
*/
@Data
@ApiModel("种植计划表")
public class FarmPlanting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
            /**
                * 编号
                */
            @ApiModelProperty("编号")
            private String code;

            /**
                * 土地名称
                */
            @ApiModelProperty("土地名称")
            private String landName;

            /**
                * 规模
                */
            @ApiModelProperty("规模")
            private String scale;

            /**
                * 面积
                */
            @ApiModelProperty("面积")
            private Integer area;

            /**
                * 种植数量
                */
            @ApiModelProperty("种植数量")
            private Long plantingPlantNumber;

            /**
                * 状态 1 启动计划 2 正在进行 3 废弃
                */
            @ApiModelProperty("状态 1 启动计划 2 正在进行 3 废弃")
            private Long status;

            /**
                * 适合作物
                */
            @ApiModelProperty("适合作物")
            private String suitableCrop;

            /**
                * 植物名称
                */
            @ApiModelProperty("植物名称")
            private String plantName;

            /**
                * 分类
                */
            @ApiModelProperty("分类")
            private String classification;

            /**
                * 生长周期
                */
            @ApiModelProperty("生长周期")
            private String growthCycle;

            /**
                * 温度建议
                */
            @ApiModelProperty("温度建议")
            private String temperatureRecommendation;

            /**
                * 湿度建议
                */
            @ApiModelProperty("湿度建议")
            private String humidityRecommendation;

            /**
                * 植物图片
                */
            @ApiModelProperty("植物图片")
            private String plantImage;

            /**
                * 种植日期
                */
            @ApiModelProperty("种植日期")
            private Date plantingDate;

            /**
                * 收割日期
                */
            @ApiModelProperty("收割日期")
            private Date harvestDate;

            /**
                * 当前状态
                */
            @ApiModelProperty("当前状态")
            private String currentStatus;

            /**
                * 备注
                */
            @ApiModelProperty("备注")
            private String remarks;

            /**
                * 用户名
                */
            @ApiModelProperty("用户名")
            private String username;

            /**
                * 手机号码
                */
            @ApiModelProperty("手机号码")
            private String phoneNumber;

            /**
                * 用户 id
                */
            @ApiModelProperty("用户 id")
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
                * 植物id
                */
            @ApiModelProperty("植物id")
            private Integer plantId;

            /**
                * 区块id
                */
            @ApiModelProperty("区块id")
            private Integer blockId;

    public FarmPlanting() {}
}
