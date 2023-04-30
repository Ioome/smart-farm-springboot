package com.farm.entity.dto;

import com.farm.restful.PageEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @name: FarmBlockDto
 * @author: sutton
 * @date: 2023-04-30 15:53
 * @description: FarmBlockDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FarmBlockDto extends PageEntity {
    @ApiModelProperty("区块id")
    private Integer id;


    @ApiModelProperty("筛选条件： 时间")
    private String time;

    @ApiModelProperty("筛选条件： 面积")
    private String area;

    @ApiModelProperty("筛选条件： 状态")
    private String status;


    @ApiModelProperty("区块编码")
    private String code;

    @ApiModelProperty("区块规模开始范围")
    private String startArea;

    @ApiModelProperty("区块规模结束范围")
    private String endArea;
}
