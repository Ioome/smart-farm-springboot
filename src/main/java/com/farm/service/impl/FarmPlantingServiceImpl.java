package com.farm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.dto.FarmPlantingDto;
import com.farm.entity.po.FarmAdmin;
import com.farm.entity.po.FarmPlanting;
import com.farm.mapper.FarmAdminMapper;
import com.farm.mapper.FarmPlantingMapper;
import com.farm.service.FarmPlantingService;
import com.farm.utils.ResponseResult;
import com.farm.utils.UserInfoUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @name: FarmPlantingServiceImpl
 * @author: sutton
 * @date: 2023-05-01 15:14
 * @description: FarmPlantingServiceImpl
 */
@Service
public class FarmPlantingServiceImpl extends ServiceImpl<FarmPlantingMapper, FarmPlanting> implements FarmPlantingService {
    @Resource
    private FarmPlantingMapper farmPlantingMapper;

    @Resource
    private FarmAdminMapper farmAdminMapper;


    @Override
    public Object insert (FarmPlanting farmPlanting) {

        // valid
        if (farmPlanting == null) {
            return ResponseResult.fail("必要参数缺失");
        }

        farmPlantingMapper.insert(farmPlanting);
        return ResponseResult.success();
    }


    @Override
    public Object delete (int id) {
        int ret = farmPlantingMapper.deleteById(id);
        return ret > 0 ? ResponseResult.success() : ResponseResult.fail("删除失败");
    }


    @Override
    public Object update (FarmPlanting farmPlanting) {
        int ret = farmPlantingMapper.updateById(farmPlanting);
        return ret > 0 ? ResponseResult.success() : ResponseResult.fail("更新失败");
    }


    @Override
    public FarmPlanting load (Integer id) {
        return farmPlantingMapper.selectById(id);
    }


    @Override
    public Map<String, Object> pageList (FarmPlantingDto dto) {
        Page<FarmPlanting> farmPlantingPage = farmPlantingMapper.selectPage(dto.getPageObj(), null);
        Map<String, Object> result = new HashMap<>();
        result.put("pageList", farmPlantingPage.getRecords());
        result.put("totalCount", farmPlantingPage.getTotal());
        return result;
    }

    /**
     * 新增种植计划表
     *
     * @param farmPlanting 种植
     */
    @Override
    public void insertfarmPlanting (FarmPlanting farmPlanting) {
        Long userId = UserInfoUtils.getUserId();
        farmPlanting.setUserId(userId);
        FarmAdmin farmAdmin = farmAdminMapper.selectById(userId);
        farmPlanting.setUsername(farmAdmin.getUsername());
        farmPlanting.setPhoneNumber(farmAdmin.getPhone());
        farmPlantingMapper.insert(farmPlanting);
    }
}
