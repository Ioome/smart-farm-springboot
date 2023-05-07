package com.farm.controller;

import com.farm.service.FarmEquipmentService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @name: BigDataController
 * @author: sutton
 * @date: 2023-04-26 15:50
 * @description: 大数据展示页面
 */
@Slf4j
@RestController
@RequestMapping("/api/data")
public class BigDataController {

    @Resource
    private FarmEquipmentService farmEquipmentService;

    /**
     * <a href="http://localhost:9241/data/getTemperature">获取气温</a>
     *
     * @return block
     */
    @ApiOperation(value = "获取气温")
    @PostMapping("/getTemperature")
    public Object getTemperature () {
        return ResponseResult.success(farmEquipmentService.getTemperature());
    }


    /**
     * <a href="http://localhost:9241/data/getHumidity">获取日照</a>
     *
     * @return 日照
     */
    @ApiOperation(value = "获取日照")
    @PostMapping("/getSunShine")
    public Object getSunShine () {
        return ResponseResult.success(farmEquipmentService.getSunShine());
    }


    /**
     * <a href="http://localhost:9241/data/getRainfall">获取降雨量</a>
     *
     * @return 返回降雨量
     */
    @ApiOperation(value = "获取降雨量")
    @PostMapping("/getRailfall")
    public Object getRainfall () {
        return ResponseResult.success(farmEquipmentService.getRainfall());
    }


    /**
     * <a href="http://localhost:9241/data/getAirTemperature">获取风速</a>
     *
     * @return 获取空气温度
     */
    @ApiOperation(value = "获取空气温度")
    @PostMapping("/getAirTemperature")
    public Object getAirTemperature () {
        return ResponseResult.success(farmEquipmentService.getAirTemp());
    }

    /**
     * <a href="http://localhost:9241/data/getAirHumidity">获取空气湿度</a>
     *
     * @return 获取空气湿度
     */
    @ApiOperation(value = "获取空气湿度")
    @PostMapping("/getAirHumidity")
    public Object getAirHumidity () {
        return ResponseResult.success(farmEquipmentService.getAirHund());
    }


    @ApiOperation(value = "获取土壤湿度")
    @PostMapping("/getLandHumidity")
    public Object getLandHumidity () {
        return ResponseResult.success(farmEquipmentService.getLandHund());
    }

    @ApiOperation(value = "获取土壤湿度")
    @PostMapping("/getLandTemperature")
    public Object getLandTemperature () {
        return ResponseResult.success(farmEquipmentService.getLandTemp());
    }


    @ApiOperation(value = "获取温度趋势")
    @GetMapping("/temptRend")
    public Object getTemptRend () {
        return ResponseResult.success(farmEquipmentService.getTemptrend());
    }

    @GetMapping(value = "/getWeek")
    @ApiOperation(value = "获取 x 轴")
    public Object getWeek () {
        List<String> week = new ArrayList<>();
        week.add("周一");
        week.add("周二");
        week.add("周三");
        week.add("周四");
        week.add("周五");
        week.add("周六");
        week.add("周日");
        return ResponseResult.success(week);
    }


    @GetMapping(value = "/getWeekY")
    @ApiOperation(value = "获取 y 轴")
    public Object getWeekY () {
        List<Integer> result = new ArrayList<>();
        int minTemp = -5;
        int maxTemp = 35;
        int tickInterval = 10;
        for (int i = minTemp; i <= maxTemp; i += tickInterval) {
            result.add(i);
        }
        return ResponseResult.success(result);
    }

    @GetMapping(value = "/getY")
    @ApiOperation(value = "获取 y 轴")
    public Object getY () {
        List<Integer> result = new ArrayList<>();
        int minTemp = 0;
        int maxTemp = 50;
        int tickInterval = 10;
        for (int i = minTemp; i <= maxTemp; i += tickInterval) {
            result.add(i);
        }
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "获取湿度趋势")
    @GetMapping("/humidityRend")
    public Object getHumidityRend () {
        return ResponseResult.success(farmEquipmentService.getHumidityRend());
    }

    @ApiOperation("获取区块")
    @GetMapping("getBlock")
    public Object getBlock () {
        return ResponseResult.success(farmEquipmentService.getBlock());
    }


    @ApiOperation("getRunTime")
    @GetMapping("getRunTime")
    public Object getRunTime () {
        return ResponseResult.success(farmEquipmentService.getSunShine());
    }
}
