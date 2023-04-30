package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.dto.FarmBlockDto;
import com.farm.entity.po.FarmBlock;
import com.farm.mapper.FarmBlockMapper;
import com.farm.service.FarmBlockService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * @name: FarmBlockServiceImpl
 * @author: sutton
 * @date: 2023-04-30 14:39
 * @description: FarmBlockServiceImpl
 */
@Service
public class FarmBlockServiceImpl extends ServiceImpl<FarmBlockMapper, FarmBlock> implements FarmBlockService {

    @Resource
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
    public Object deleteById (Integer id) throws Exception {
        FarmBlock farmBlock = farmBlockMapper.selectById(id);
        if (isNull(farmBlock)) {
            throw new Exception("数据不存在");
        }
        return farmBlockMapper.deleteById(id);
    }

    /**
     * 分页查询区块
     *
     * @param dto 分页信息
     * @return 区块列表List
     */
    @Override
    public List<FarmBlock> getBlockList (FarmBlockDto dto) {
        Page<FarmBlock> page = farmBlockMapper.selectPage(dto.getPageObj(), new QueryWrapper<FarmBlock>()
                .lambda()
                .like(StringUtils.isNoneBlank(dto.getCode()), FarmBlock::getCode, dto.getCode())
                .eq(StringUtils.isNoneBlank(dto.getArea()), FarmBlock::getArea, dto.getArea())
                .eq(StringUtils.isNoneBlank(dto.getStatus()), FarmBlock::getStatus, dto.getStatus())
                .le(StringUtils.isNoneBlank(dto.getStartTime()), FarmBlock::getCreatedTime, dto.getStartTime())
                .ge(StringUtils.isNoneBlank(dto.getEndTime()), FarmBlock::getCreatedTime, dto.getEndTime())
                .orderByDesc(FarmBlock::getCreatedTime));
        return page.getRecords();
    }
}
