package com.farm.test.service;

import com.farm.mapper.FarmEquipmentMapper;
import com.farm.service.FarmEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @name: FarmEquipmentServiceTest
 * @author: sutton
 * @date: 2023-04-28 16:58
 * @description: FarmEquipmentServiceTest
 */
@SpringBootTest
public class FarmEquipmentServiceTest {

    @Autowired
    private FarmEquipmentService farmEquipmentService;

    @Autowired
    private FarmEquipmentMapper farmEquipmentMapper;


    void test () {

    }
}
