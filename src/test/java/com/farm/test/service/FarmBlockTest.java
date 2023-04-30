package com.farm.test.service;

import com.farm.entity.po.FarmBlock;
import com.farm.mapper.FarmBlockMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @name: FarmBlockTest
 * @author: sutton
 * @date: 2023-04-30 14:57
 * @description: FarmBlockTest
 */
@SpringBootTest
class FarmBlockTest {

    private final Logger logger = LoggerFactory.getLogger(FarmBlockTest.class);

    @Autowired
    private FarmBlockMapper farmBlockMapper;

    @Test
    void test () {
        logger.info("farmBlockMapper: {}", farmBlockMapper);
        logger.info("farmBlockMapper.selectById(1): {}", farmBlockMapper.selectById(1));
    }
}
