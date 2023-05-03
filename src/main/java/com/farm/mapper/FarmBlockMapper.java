package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmBlock;
import com.farm.entity.vo.FarmBlockValueAndNameVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: sutton
 * @date: 2023-04-30 14:37
 * @description: 农场地块表
 * @name: FarmBlockMapper
 */
@Mapper
public interface FarmBlockMapper extends BaseMapper<FarmBlock> {
    List<FarmBlockValueAndNameVo> selectFarmBlockValueAndName ();
}