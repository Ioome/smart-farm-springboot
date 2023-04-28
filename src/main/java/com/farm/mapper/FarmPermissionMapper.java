package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @name: FarmPermissionMapper
 * @author: sutton
 * @date: 2023-04-27 23:02
 * @description: 权限表
 */
@Mapper
public interface FarmPermissionMapper extends BaseMapper<FarmPermission> {

    /**
     * 根据用户id查询权限
     *
     * @param id 用户id
     * @return 权限列表
     */
    List<String> selectPermsByUserId (Long id);
}

