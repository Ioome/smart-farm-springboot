package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.po.FarmLocation;
import com.farm.mapper.FarmLocationMapper;
import com.farm.service.FarmLocationService;
import org.springframework.stereotype.Service;

/**
 * @name: FarmLocationServiceImpl
 * @author: sutton
 * @date: 2023-05-02 14:55
 * @description: FarmLocationServiceImpl
 */
@Service
public class FarmLocationServiceImpl extends ServiceImpl<FarmLocationMapper, FarmLocation> implements FarmLocationService {

}
