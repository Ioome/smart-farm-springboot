package com.farm.restful;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @name: PageEntity
 * @author: sutton
 * @date: 2023-04-26 21:26
 * @description: PageEntity
 */
@Data
public class PageEntity implements Serializable {
    /**
     * 总数
     */
    @ApiModelProperty("总数")
    @TableField(exist = false)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */

    @ApiModelProperty("每页显示条数，默认 10")
    @TableField(exist = false)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    protected long size = 10;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    @TableField(exist = false)

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    protected long page = 1;


    /**
     * mybatis-plus 自动查总数标识
     */
    @ApiModelProperty("mybatis-plus 自动查总数标识")
    @TableField(exist = false)

    @JsonIgnore

    protected boolean searchCount = true;


    @JsonIgnore
    public <E> Page<E> getPageObj () {
        return new Page<>(page, size, total, searchCount);
    }

    public <E> Page<E> getPageObj (long p, long s) {
        return new Page<>(p, s, searchCount);
    }

    public <E> Page<E> getPageObj (long p, long s, boolean searchCount) {
        return new Page<>(p, s, searchCount);
    }


}
