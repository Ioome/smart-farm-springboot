package com.farm.test.service;

import com.farm.entity.po.WeatherData;
import com.farm.entity.vo.FarmTempTrendVo;
import com.farm.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * @name: IpTest
 * @author: sutton
 * @date: 2023-05-03 19:07
 * @description: IpTest
 */
@SpringBootTest
@Slf4j
public class IpTest {

    private Logger logger = LoggerFactory.getLogger(IpTest.class);

    @Value("${real.weather.key}")
    private String value;
    @Resource
    private RestTemplate restTemplate;


    @Test
    void test () {

        logger.info("开始获取温度趋势");
        WeatherData forObject = restTemplate.getForObject("https://devapi.qweather.com/v7/grid-weather/7d?location=116.41,39.92&key={key}", WeatherData.class, value);
        if (isNull(forObject.getDaily())) {
            throw new MyException("获取天气失败");
        }
        List<FarmTempTrendVo> farmTempTrendVos = new ArrayList<>();
        for (WeatherData.DailyWeatherData dailyBean : forObject.getDaily()) {
            farmTempTrendVos.add(new FarmTempTrendVo(dailyBean.getFxDate(), dailyBean.getTempMax(), dailyBean.getTempMin()));
        }

        logger.info("farmTempTrendVos: {}", farmTempTrendVos);
        logger.info("获取成功");
    }
}
