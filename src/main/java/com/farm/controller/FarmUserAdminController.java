package com.farm.controller;

import com.farm.entity.po.FarmAdmin;
import com.farm.exception.FarmExceptionEnum;
import com.farm.exception.MyException;
import com.farm.service.FarmAdminService;
import com.farm.utils.ResponseResult;
import com.farm.validation.group.RegisterGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/admin")
public class FarmUserAdminController {

    @Resource
    private FarmAdminService farmAdminService;


    /**
     * <a href="http://localhost:9241/api/admin/register">...</a>
     *
     * @param umsAdminParam 注册信息
     * @param result        返回结果
     * @return 返回 json
     */
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @Transactional(rollbackFor = Exception.class)
    public Object register (@Validated(RegisterGroup.class) @RequestBody FarmAdmin umsAdminParam, BindingResult result) {
        FarmAdmin umsAdmin = farmAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            throw new MyException("注册失败");
        }
        return ResponseResult.success("注册成功,某古同志看到了，那么他就是一大傻逼，世界上最大的傻逼");
    }


    /**
     * <a href="http://localhost:9241/api/admin/login">...</a>
     *
     * @param farmAdmin 登录 账户 密码
     * @param result    返回结果
     * @return 返回 json
     */
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


    /**
     * <a href="http://localhost:9241/api/admin/logout">...</a>
     *
     * @return 返回 结果
     */
    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/logout")
    @Transactional(rollbackFor = Exception.class)
    public Object logout () {
        farmAdminService.logout();
        return ResponseResult.success("退出成功");
    }
}
