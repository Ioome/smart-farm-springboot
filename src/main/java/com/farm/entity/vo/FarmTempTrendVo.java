package com.farm.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @name: FarmTempTrendVo
 * @author: sutton
 * @date: 2023-05-07 16:26
 * @description: FarmTempTrendVo
 */
@Data
@AllArgsConstructor
public class FarmTempTrendVo {

    private String fxDate;

    private String tempMax;

    private String tempMin;
}
