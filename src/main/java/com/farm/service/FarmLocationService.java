package com.farm.service;

import com.farm.entity.dto.FarmLocationDto;
import com.farm.entity.po.FarmLocation;
import com.farm.entity.vo.FarmLocationVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author sutton
 * @description 城市表服务层
 * @date 2023-05-02
 */
@Service
public interface FarmLocationService extends IService<FarmLocation> {


    /**
     * 根据城市名称获取城市id
     *
     * @param dto 城市名称
     * @return 返回城市id
     */
    FarmLocationVo getCityInfo (FarmLocationDto dto);
}
