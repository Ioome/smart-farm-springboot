package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.dto.FarmLocationDto;
import com.farm.entity.po.CityInfo;
import com.farm.entity.po.FarmLocation;
import com.farm.entity.vo.FarmLocationVo;
import com.farm.mapper.FarmLocationMapper;
import com.farm.service.FarmLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: FarmLocationServiceImpl
 * @author: sutton
 * @date: 2023-05-02 14:55
 * @description: FarmLocationServiceImpl
 */
@Service
@Slf4j
public class FarmLocationServiceImpl extends ServiceImpl<FarmLocationMapper, FarmLocation> implements FarmLocationService {


    @Autowired
    private FarmLocationMapper farmLocationMapper;


    @Value("${qweather.geoapi.key}")
    private String key;

    /**
     * 根据城市名称获取城市id
     *
     * @param dto 城市名称
     * @return 返回城市id
     */
    @Override
    public FarmLocationVo getCityInfo (FarmLocationDto dto) {
        log.info("开始调用城市接口......");
        log.info("请求成功 {}");
        return null;
    }
}
