package com.farm.service.impl;

import com.farm.entity.vo.FarmPassWordVo;
import com.farm.service.FarmAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FarmAdminServiceImplTest {

    @Resource
    private FarmAdminService farmAdminService;

    @Test
    void updatePassword () {
        FarmPassWordVo farmPassWordVo = new FarmPassWordVo();
        farmPassWordVo.setOldPassword("");
        farmPassWordVo.setNewPassword("9978111");
        farmAdminService.updatePassword(farmPassWordVo);
    }
}