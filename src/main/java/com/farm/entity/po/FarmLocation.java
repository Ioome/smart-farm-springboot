package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sutton
 * @description 城市表
 * @date 2023-05-02
 */
@Data
@ApiModel("城市表")
public class FarmLocation implements Serializable {

    private static final Long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 地点id
     */
    @ApiModelProperty("地点id")
    private Integer locationId;

    /**
     * 地点名称
     */
    @ApiModelProperty("地点名称")
    private String locationName;

    /**
     * 地点纬度
     */
    @ApiModelProperty("地点纬度")
    private String locationLat;

    /**
     * 地点经度
     */
    @ApiModelProperty("地点经度")
    private String locationLon;

    /**
     * 地点所属区县
     */
    @ApiModelProperty("地点所属区县")
    private String locationAdm2;

    /**
     * 地点所属市
     */
    @ApiModelProperty("地点所属市")
    private String locationAdm1;

    /**
     * 地点所属国家
     */
    @ApiModelProperty("地点所属国家")
    private String locationCountry;

    /**
     * 地点时区
     */
    @ApiModelProperty("地点时区")
    private String locationTz;

    /**
     * 地点utc
     */
    @ApiModelProperty("地点utc")
    private String locationUtc;

    /**
     * 地点utcoffset
     */
    @ApiModelProperty("地点utcoffset")
    private String locationUtcoffset;

    /**
     * 地点isdst
     */
    @ApiModelProperty("地点isdst")
    private String locationIsdst;

    /**
     * 地点类型
     */
    @ApiModelProperty("地点类型")
    private String locationType;

    /**
     * 地点rank
     */
    @ApiModelProperty("地点rank")
    private String locationRank;

    /**
     * 地点fxlink
     */
    @ApiModelProperty("地点fxlink")
    private String locationFxlink;

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
     * 主环境id
     */
    @ApiModelProperty("主环境id")
    private Integer parentId;

    /**
     * 区块
     */
    @ApiModelProperty("区块")
    private Integer blockId;

    /**
     * 设备
     */
    @ApiModelProperty("设备")
    private Integer equipment;

}
