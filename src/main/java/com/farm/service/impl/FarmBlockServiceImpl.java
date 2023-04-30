package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.po.FarmBlock;
import com.farm.mapper.FarmBlockMapper;
import com.farm.service.FarmBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name: FarmBlockServiceImpl
 * @author: sutton
 * @date: 2023-04-30 14:39
 * @description: FarmBlockServiceImpl
 */
@Service
public class FarmBlockServiceImpl extends ServiceImpl<FarmBlockMapper, FarmBlock> implements FarmBlockService {

    @Autowired
    private FarmBlockMapper farmBlockMapper;


    /**
     * 获取所有农田
     *
     * @return 农田列表
     */
    @Override
    public List<FarmBlock> getAll () {
        return farmBlockMapper.selectList(null);
    }

    /**
     * 根据id获取农田
     *
     * @param id id 信息
     * @return 农田个别信息
     */
    @Override
    public FarmBlock getOne (Long id) {
        return farmBlockMapper.selectById(id);
    }

    /**
     * 根据 id 删除
     *
     * @param id 删除 id
     * @return 返回删除后的信息
     */
    @Override
    public Object deleteById (Integer id) {
        return farmBlockMapper.deleteById(id);
    }
}
