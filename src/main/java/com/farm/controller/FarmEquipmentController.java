package com.farm.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.farm.entity.dto.FarmEquipmentDto;
import com.farm.entity.po.FarmEquipment;
import com.farm.mapper.FarmEquipmentMapper;
import com.farm.restful.BaseController;
import com.farm.service.FarmEquipmentService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sutton
 * @description 设备controller层
 * @date 2023-05-01
 */
@Slf4j
@RestController
@RequestMapping("/api/equipment")
public class FarmEquipmentController extends BaseController {

    @Resource
    private FarmEquipmentService farmEquipmentService;

    @Autowired
    private FarmEquipmentMapper farmEquipmentMapper;


    /**
     * <a href="http://localhost:9241/farm/api/saveEquipment">...</a>
     * 获取所有硬件
     *
     * @return 返回所有硬件
     */
    @ApiOperation(value = "获取所有硬件")
    @PostMapping(value = "/getEqupmentLists")
    public Object getPlan () {
        List<FarmEquipment> farmPlantings = farmEquipmentService.getEqupmentLists();
        return ResponseResult.success(farmPlantings);
    }


    @ApiOperation(value = "设置第三方 api")
    @PostMapping(value = "/setData")
    public Object setData(){
        farmEquipmentService.setApiData();
        return ResponseResult.success();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Object delete (@RequestBody FarmEquipmentDto dto) {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getId, dto.getId()));
        if (farmEquipment != null) {
            farmEquipmentMapper.deleteById(dto.getId());
            return ResponseResult.success();
        } else {
            return ResponseResult.fail("没有找到该对象");
        }
    }

    /**
     * 查询
     */
    @PostMapping("/find")
    public Object find (@RequestBody FarmEquipment dto) {
        FarmEquipment farmEquipment = farmEquipmentMapper.selectOne(new QueryWrapper<FarmEquipment>().lambda().eq(FarmEquipment::getId, dto.getId()));
        if (farmEquipment != null) {
            return ResponseResult.success(farmEquipment);
        } else {
            return ResponseResult.fail("没有找到该对象");
        }
    }

    @PostMapping("/list")
    public Object list (@RequestBody FarmEquipmentDto dto) {
        log.info("page:" + dto.getPageObj().getPages() + "-limit:" + dto.getPageObj().getSize() + "-json:" + JSON.toJSONString(dto));
        //执行分页
        Page<FarmEquipment> pageList = farmEquipmentMapper.selectPage(dto.getPageObj(), new QueryWrapper<FarmEquipment>().lambda()
                .like(StringUtils.isNotBlank(dto.getEquipmentName()), FarmEquipment::getEquipmentName, dto.getEquipmentName())
                .like(StringUtils.isNotBlank(dto.getEquipmentNumber()), FarmEquipment::getEquipmentNumber, dto.getEquipmentNumber()));
        //返回结果
        return toResult(pageList.getRecords());
    }
}



