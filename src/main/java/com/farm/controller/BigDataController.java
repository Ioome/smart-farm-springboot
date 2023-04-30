package com.farm.controller;

import com.farm.service.FarmEquipmentService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @name: BigDataController
 * @author: sutton
 * @date: 2023-04-26 15:50
 * @description: 大数据展示页面
 */
@Slf4j
@RestController
@RequestMapping("/data")
@Api(value = "BigDataController", tags = "data Interface")
public class BigDataController {

    @Resource
    private FarmEquipmentService farmEquipmentService;

    /**
     * <a href="http://localhost:9241/data/getTemperature">获取气温</a>
     *
     * @return block
     */
    @ApiOperation(value = "获取气温")
    @RequestMapping("/getTemperature")
    public Object getTemperature () {
        return ResponseResult.success();
    }


    /**
     * <a href="http://localhost:9241/data/getHumidity">获取日照</a>
     *
     * @return 日照
     */
    @ApiOperation(value = "获取日照")
    @RequestMapping("/getSunShine")
    public Object getSunShine () {
        return ResponseResult.success();
    }


    /**
     * <a href="http://localhost:9241/data/getRainfall">获取降雨量</a>
     *
     * @return 返回降雨量
     */
    @ApiOperation(value = "获取降雨量")
    @RequestMapping("/getRailfall")
    public Object getRainfall () {
        return ResponseResult.success();
    }


    /**
     * <a href="http://localhost:9241/data/getAirTemperature">获取风速</a>
     *
     * @return 获取空气温度
     */
    @ApiOperation(value = "获取空气温度")
    @RequestMapping("/getAirTemperature")
    public Object getAirTemperature () {
        return ResponseResult.success();
    }

    /**
     * <a href="http://localhost:9241/data/getAirHumidity">获取空气湿度</a>
     *
     * @return 获取空气湿度
     */
    @ApiOperation(value = "获取空气湿度")
    @RequestMapping("/getAirHumidity")
    public Object getAirHumidity () {
        return ResponseResult.success();
    }


    @ApiOperation(value = "获取土壤温湿度")
    @RequestMapping("/getLandHumidity")
    public Object getLandHumidity () {
        return ResponseResult.success();
    }

    @ApiOperation(value = "获取土壤温湿度")
    @RequestMapping("/getAirTemperature")
    public Object getLandTemperature () {
        return ResponseResult.success();
    }

}
