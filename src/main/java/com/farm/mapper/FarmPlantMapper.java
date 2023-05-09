package com.farm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.farm.entity.po.FarmPlant;
import com.farm.entity.vo.FarmPlantVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sutton
 * @description 植物Mapper
 * @date 2023-05-01
 */
@Mapper
public interface FarmPlantMapper extends BaseMapper<FarmPlant> {

    /**
     * 大数据接口获取植物信息
     *
     * @returns List<FarmPlantVo>  返回 name value
     */
    List<FarmPlantVo> getFunnel ();


    /**
     * 返回植物列表
     *
     * @return 返回植物种类
     */
    List<String> getFunnelPlantList ();
}