package com.farm.controller;

import com.farm.entity.po.FarmAdmin;
import com.farm.exception.FarmExceptionEnum;
import com.farm.service.FarmAdminService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: FarmUserAdminController
 * @author: sutton
 * @date: 2023-04-27 10:26
 * @description: FarmUserAdminController
 */

@Slf4j
@Controller
@Api(tags = "FarmUserAdminController", value = "后台用户管理")
@RequestMapping("/api/admin")
public class FarmUserAdminController {

    @Resource
    private FarmAdminService farmAdminService;


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public Object register (@RequestBody FarmAdmin umsAdminParam, BindingResult result) {
        FarmAdmin umsAdmin = farmAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            ResponseResult.fail(FarmExceptionEnum.LOGIN_ERROR.getMessage());
        }
        return ResponseResult.success(umsAdmin);
    }


    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    @ResponseBody
    public Object login (@RequestBody FarmAdmin farmAdmin, BindingResult result) {
        String token = farmAdminService.login(farmAdmin);
        if (token == null) {
            return ResponseResult.fail("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", "token");
        return ResponseResult.success(tokenMap);
    }


    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/logout")
    @Transactional(rollbackFor = Exception.class)
    public Object logout () {
        farmAdminService.logout();
        return ResponseResult.success("退出成功");
    }
}
