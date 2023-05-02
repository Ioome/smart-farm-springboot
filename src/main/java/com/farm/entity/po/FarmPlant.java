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
 * @description 植物
 * @date 2023-05-01
 */
@Data
@ApiModel("植物")
public class FarmPlant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 植物名称
     */
    @ApiModelProperty("植物名称")
    private String plantName;

    /**
     * 分类
     */
    @ApiModelProperty("分类")
    private String plantClassification;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String picture;

    /**
     * 生长周期
     */
    @ApiModelProperty("生长周期")
    private String growthCycle;

    /**
     * 营养价值
     */
    @ApiModelProperty("营养价值")
    private String nutritionalValue;

    /**
     * 施肥品种
     */
    @ApiModelProperty("施肥品种")
    private String fertVarieties;

    /**
     * 光照周期
     */
    @ApiModelProperty("光照周期")
    private String sunCycle;

    /**
     * 土壤建议
     */
    @ApiModelProperty("土壤建议")
    private String landCondition;

    /**
     * 温度建议
     */
    @ApiModelProperty("温度建议")
    private String tempCondition;

    /**
     * 湿度建议
     */
    @ApiModelProperty("湿度建议")
    private String humidityCondition;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

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
     * 仓库id
     */
    @ApiModelProperty("仓库id")
    private Integer warehouseId;

    public FarmPlant () {
    }
}
