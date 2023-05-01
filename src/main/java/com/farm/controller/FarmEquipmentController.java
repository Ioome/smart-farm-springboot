package com.farm.controller;

import com.farm.entity.dto.FarmBlockDto;
import com.farm.entity.po.FarmEquipment;
import com.farm.entity.po.FarmPlanting;
import com.farm.service.FarmEquipmentService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sutton
 * @description 设备controller层
 * @date 2023-05-01
 */
@Slf4j
@RestController
@RequestMapping("/equipment")
public class FarmEquipmentController {

    @Resource
    private FarmEquipmentService farmEquipmentService;


    @ApiOperation(value = "获取所有硬件")
    @PostMapping(value = "/getEqupmentLists")
    public Object getPlan (@RequestBody FarmEquipment param) {
        List<FarmEquipment> farmPlantings = farmEquipmentService.getEqupmentLists();
        return ResponseResult.success(farmPlantings);
    }
}



