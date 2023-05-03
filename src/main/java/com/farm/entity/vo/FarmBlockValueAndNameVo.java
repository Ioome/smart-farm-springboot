package com.farm.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @name: FarmBlockValueAndNameVo
 * @author: sutton
 * @date: 2023-05-03 15:00
 * @description: FarmBlockValueAndNameVo
 */
@Data
public class FarmBlockValueAndNameVo {


    private Integer id;

    private String landName;

    private BigDecimal allArea;
}
