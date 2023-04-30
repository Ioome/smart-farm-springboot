package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FarmBlock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

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
    * 状态 1 启动 2 回收 3 废弃
    */
    private Long status;

    /**
    * 图片
    */
    private String image;

    /**
    * 规模
    */
    private String scale;

    /**
    * 面积
    */
    private Integer area;

    /**
    * 适合作物
    */
    private String suitableCrop;

    /**
    * 详情
    */
    private String details;

    /**
    * 最后点击时间
    */
    private Date clickTime;

    /**
    * 点击数
    */
    private Integer clickCount;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 更新人
    */
    private Integer updateBy;

    /**
    * 创建人
    */
    private Integer createBy;

    /**
    * 删除（null.正常)
    */
    private Date deleteTime;
}