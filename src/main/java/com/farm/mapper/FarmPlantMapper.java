package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmPlant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sutton
 * @description 植物Mapper
 * @date 2023-05-01
 */
@Mapper
public interface FarmPlantMapper extends BaseMapper<FarmPlant> {}