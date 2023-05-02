package com.farm.controller;

import com.farm.entity.dto.FarmLocationDto;
import com.farm.entity.vo.FarmLocationVo;
import com.farm.service.FarmLocationService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/farmLocation")
public class FarmLocationController {


    @Autowired
    private FarmLocationService farmLocationService;

    /**
     * 根据城市获取城市响应的id
     *
     * @return 返回城市名字和id以及
     */
    @ApiOperation(value = "获取城市信息")
    @GetMapping("/getCityInfo")
    public Object getCityInfo (@RequestBody FarmLocationDto dto) {
        FarmLocationVo citys = farmLocationService.getCityInfo(dto);
        return ResponseResult.success(citys);
    }


}