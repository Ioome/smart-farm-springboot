package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmEquipment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @name: FarmEquipmentMapper
 * @author: sutton
 * @date: 2023-04-28 16:49
 * @description: FarmEquipmentMapper
 */
@Mapper
public interface FarmEquipmentMapper extends BaseMapper<FarmEquipment> {
}
