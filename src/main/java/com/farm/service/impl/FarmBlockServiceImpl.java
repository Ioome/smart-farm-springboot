package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.po.FarmBlock;
import com.farm.mapper.FarmBlockMapper;
import com.farm.service.FarmBlockService;
import org.springframework.stereotype.Service;

/**
 * @name: FarmBlockServiceImpl
 * @author: sutton
 * @date: 2023-04-30 14:39
 * @description: FarmBlockServiceImpl
 */
@Service
public class FarmBlockServiceImpl extends ServiceImpl<FarmBlockMapper, FarmBlock> implements FarmBlockService {
}
