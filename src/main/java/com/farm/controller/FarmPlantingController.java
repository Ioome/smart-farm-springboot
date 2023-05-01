package com.farm.controller;

import com.alibaba.fastjson.JSON;
import com.farm.entity.po.FarmPlanting;
import com.farm.mapper.FarmPlantingMapper;
import com.farm.utils.ResponseResult;
import www.itgongju.com.entity.FarmPlanting;
import www.itgongju.com.mapper.FarmPlantingMapper;
import www.itgongju.com.util.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author www.itgongju.com
 * @description 种植计划表controller层
 * @date 2023-05-01
 */
@Slf4j
@RestController
@RequestMapping("/farmPlanting")
public class FarmPlantingController {

}



