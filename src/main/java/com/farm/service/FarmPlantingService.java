package com.farm.service;

import com.farm.entity.dto.FarmPlantingDto;
import com.farm.entity.po.FarmPlanting;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author www.itgongju.com
 * @description 种植计划表服务层
 * @date 2023-05-01
 */
@Service
public interface FarmPlantingService extends IService<FarmPlanting> {


    /**
     * 新增
     *
     * @param farmPlanting 实体对象
     * @return 返回插入成功的ID
     */
    Object insert (FarmPlanting farmPlanting);

    /**
     * 删除
     */
    Object delete (int id);

    /**
     * 更新
     */
    Object update (FarmPlanting farmPlanting);

    /**
     * 根据主键 id 查询
     */
    FarmPlanting load (Integer id);


    /**
     * 分页查询
     *
     * @param dto dto
     * @return 返回分页数据
     */
    Map<String, Object> pageList (FarmPlantingDto dto);


    /**
     * 新增种植计划表
     * @param farmPlanting 种植
     */
    void insertfarmPlanting (FarmPlanting farmPlanting);
}
