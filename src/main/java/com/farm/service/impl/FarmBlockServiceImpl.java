package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.dto.FarmBlockDto;
import com.farm.entity.po.FarmBlock;
import com.farm.entity.po.FarmPlanting;
import com.farm.entity.vo.FarmBlockValueAndNameVo;
import com.farm.mapper.FarmBlockMapper;
import com.farm.mapper.FarmPlantingMapper;
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

    @Resource
    private FarmPlantingMapper farmPlantingMapper;


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
        FarmBlock farmBlock = farmBlockMapper.selectById(id);
        List<FarmPlanting> farmPlantings = farmPlantingMapper.selectList(new QueryWrapper<FarmPlanting>().lambda().eq(FarmPlanting::getBlockId, id));
        
        return farmBlock;
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
        List<FarmPlanting> farmPlantings = farmPlantingMapper.selectList(new QueryWrapper<FarmPlanting>().lambda().eq(FarmPlanting::getBlockId, id));
        if (isNull(farmPlantings) || farmPlantings.size() == 0) {
            return farmBlockMapper.deleteById(id);
        }
        for (FarmPlanting farmPlanting : farmPlantings) {
            if (farmPlanting.getStatus().equals(3)) {
                return farmPlantingMapper.deleteById(id);
            }
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
                .eq(StringUtils.isNoneBlank(dto.getArea()), FarmBlock::getAllArea, dto.getArea())
                .eq(StringUtils.isNoneBlank(dto.getStatus()), FarmBlock::getStatus, dto.getStatus())
                .le(StringUtils.isNoneBlank(dto.getStartTime()), FarmBlock::getCreatedTime, dto.getStartTime())
                .ge(StringUtils.isNoneBlank(dto.getEndTime()), FarmBlock::getCreatedTime, dto.getEndTime())
                .orderByDesc(FarmBlock::getCreatedTime));
        return page.getRecords();
    }

    /**
     * 查看当前区块的种植计划
     *
     * @param id 区块
     * @return 返回区块计划
     */
    @Override
    public List<FarmPlanting> getPlan (Integer id) {
        return farmPlantingMapper.selectList(new QueryWrapper<FarmPlanting>().lambda().eq(FarmPlanting::getBlockId, id));
    }

    /**
     * 回收区块
     *
     * @param id 回收区块id
     */
    @Override
    public void getRecycle (Integer id) {
        FarmBlock farmBlock = new FarmBlock();
        farmBlock.setId(Long.valueOf(id));
        farmBlock.setStatus(2L);
        farmBlockMapper.updateById(farmBlock);
    }

    /**
     * 新增区块
     *
     * @param farmBlock 区块信息
     */
    @Override
    public void saveBlock (FarmBlock farmBlock) {
        farmBlock.setStatus(1L);
        farmBlockMapper.insert(farmBlock);
    }

    @Override
    public List<FarmBlockValueAndNameVo> getValueAndName () {
        return farmBlockMapper.selectFarmBlockValueAndName();
    }
}
