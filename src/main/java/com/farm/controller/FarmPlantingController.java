package com.farm.controller;

import com.farm.entity.dto.FarmPlantingDto;
import com.farm.entity.po.FarmPlanting;
import com.farm.service.FarmPlantingService;
import com.farm.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * @author sutton
 * @description 种植计划表controller层
 * @date 2023-05-01
 */
@Slf4j
@RestController
@RequestMapping("/api/planting")
public class FarmPlantingController {


    @Resource
    private FarmPlantingService farmPlantingService;


    @RequestMapping("/insert")
    public Object insert (@RequestBody FarmPlanting farmPlanting) {
        farmPlantingService.insertfarmPlanting(farmPlanting);
        return ResponseResult.success();
    }


    @RequestMapping("/delete")
    public Object delete (int id) {
        return farmPlantingService.delete(id);
    }


    @RequestMapping("/update")
    public Object update (@RequestBody FarmPlanting farmPlanting) {
        return farmPlantingService.update(farmPlanting);
    }


    @RequestMapping("/getPlanting")
    public Object load (@RequestBody FarmPlantingDto param) {
        if (isNull(farmPlantingService.load(param.getId()))) {
            return ResponseResult.success(new ArrayList<>());
        }
        return ResponseResult.success(farmPlantingService.load(param.getId()));
    }


    @RequestMapping("/pageList")
    public Map<String, Object> pageList (@RequestBody FarmPlantingDto dto) {
        return farmPlantingService.pageList(dto);
    }
}



