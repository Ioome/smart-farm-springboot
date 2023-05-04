package com.farm.test.service;

import com.farm.entity.dto.RealTimeWeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: RestTest
 * @author: sutton
 * @date: 2023-05-03 20:24
 * @description: RestTest
 */
@SpringBootTest
@Slf4j
class RestTest {

    @Resource
    private RestTemplate restTemplate;


    /**
     * 获取实时天气
     */
    @Test
    @Scheduled(initialDelay = 10000, fixedRate = 60000)
    void Test () {
        Map<String, String> params = new HashMap<>();
        params.put("key", "9ec06f0991f148329cb53aa90bcd1d70");  //
        //获取当前地理位置

        RealTimeWeatherDto forObject = restTemplate.getForObject("https://devapi.qweather.com/v7/weather/now?location=101010100&key={key}", RealTimeWeatherDto.class, params);
        log.info("forObject: {}", forObject);
    }


}
