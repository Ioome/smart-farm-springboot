package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmLocation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sutton
 * @description 城市表Mapper
 * @date 2023-05-02
 */
@Mapper
public interface FarmLocationMapper extends BaseMapper<FarmLocation> {

}