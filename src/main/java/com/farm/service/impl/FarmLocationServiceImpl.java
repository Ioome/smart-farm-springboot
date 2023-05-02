package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.dto.FarmLocationDto;
import com.farm.entity.po.FarmLocation;
import com.farm.entity.vo.FarmLocationVo;
import com.farm.feign.GeoApiService;
import com.farm.mapper.FarmLocationMapper;
import com.farm.service.FarmLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: FarmLocationServiceImpl
 * @author: sutton
 * @date: 2023-05-02 14:55
 * @description: FarmLocationServiceImpl
 */
@Service
public class FarmLocationServiceImpl extends ServiceImpl<FarmLocationMapper, FarmLocation> implements FarmLocationService {


    @Autowired
    private FarmLocationMapper farmLocationMapper;

    @Autowired
    private GeoApiService geoApiService;

    /**
     * 根据城市名称获取城市id
     *
     * @param dto 城市名称
     * @return 返回城市id
     */
    @Override
    public FarmLocationVo getCityInfo (FarmLocationDto dto) {
        return null;
    }
}
