package com.farm.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @name: BigDataController
 * @author: sutton
 * @date: 2023-04-26 15:50
 * @description: 大数据展示页面
 */
@Slf4j
@RestController
@RequestMapping("api/{v}/data")
@Api(value = "BigDataController", tags = "data Interface")
public class BigDataController {
}
