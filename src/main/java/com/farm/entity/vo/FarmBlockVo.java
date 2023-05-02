package com.farm.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @name: FarmBlockVo
 * @author: sutton
 * @date: 2023-04-30 15:17
 * @description: 返回给前端信息
 */
@Data
public class FarmBlockVo {

    /**
     * 编号
     */
    private String code;

    /**
     * 土地名称
     */
    private String landName;

    /**
     * 土地编码
     */
    private String landCode;

    /**
     * 土地期限
     */
    private Date landTime;

    /**
     * 土地地理位置
     */
    private String landPosition;

    /**
     * 规模
     */
    private String scale;

    /**
     * 面积
     */
    private Integer allArea;

    /**
     * 适合作物
     */
    private String suitableCrop;

    /**
     * 详情
     */
    private String details;

}