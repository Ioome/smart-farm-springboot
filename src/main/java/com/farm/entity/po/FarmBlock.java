package com.farm.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class FarmBlock implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;


    @NotEmpty(message = "could not be empty")
    /**
     * 编号
     */
    private String code;


    @NotEmpty(message = "could not be empty")
    /**
     * 土地名称
     */
    private String landName;


    @NotEmpty(message = "could not be empty")
    /**
     * 土地编码
     */
    private String landCode;

    @NotEmpty(message = "could not be empty")
    /**
     * 土地期限
     */
    private String landTime;


    @NotEmpty(message = "could not be empty")
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


    @NotEmpty(message = "could not be empty")
    /**
     * 规模
     */
    private String scale;


    @NotEmpty(message = "could not be empty")
    /**
     * 面积
     */
    private Integer allArea;

    /**
     * 适合作物
     */
    private String suitableCrop;

    @NotEmpty(message = "could not be empty")
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
    @TableLogic
    private Date deleteTime;
}