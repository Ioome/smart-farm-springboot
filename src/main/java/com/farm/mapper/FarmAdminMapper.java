package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmAdmin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @name: FarmAdminMapper
 * @author: sutton
 * @date: 2023-04-27 11:44
 * @description: FarmAdminMapper
 */
@Mapper
public interface FarmAdminMapper extends BaseMapper<FarmAdmin> {
}
