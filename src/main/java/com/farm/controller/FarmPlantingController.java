package com.farm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sutton
 * @description 种植计划表controller层
 * @date 2023-05-01
 */
@Slf4j
@RestController
@RequestMapping("/planting")
public class FarmPlantingController {

    @ApiOperation(value = "种植计划")
    @ResponseBody
    public Object getPlantingList () {
        return null;
    }
}



