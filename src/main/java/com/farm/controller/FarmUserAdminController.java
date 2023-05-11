package com.farm.controller;

import com.farm.entity.dto.FarmAdminInfoDto;
import com.farm.entity.po.FarmAdmin;
import com.farm.entity.vo.FarmAdminVo;
import com.farm.entity.vo.FarmPassWordVo;
import com.farm.exception.MyException;
import com.farm.service.FarmAdminService;
import com.farm.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="http://localhost:9241/farm/api/admin">...</a>
 *
 * @name: FarmUserAdminController
 * @author: sutton
 * @date: 2023-04-27 10:26
 * @description: 用户管理
 */

@Slf4j
@RestController
@Api(tags = "FarmUserAdminController", value = "后台用户管理")
@RequestMapping("/api/admin")
public class FarmUserAdminController {

    @Resource
    private FarmAdminService farmAdminService;


    /**
     * <a href="http://localhost:9241/api/admin/register">...</a>
     *
     * @param umsAdminParam 注册信息
     * @return 返回 json
     */
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    @Transactional(rollbackFor = Exception.class)
    public Object register (@RequestBody FarmAdmin umsAdminParam) {
        FarmAdmin umsAdmin = farmAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            throw new MyException("注册失败");
        }
        return ResponseResult.success();
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
            throw new MyException("用户名或密码错误");
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

    @ApiOperation(value = "生成公钥")
    @GetMapping(value = "/getPublicKey")
    public Object getPublicKey () {
        return ResponseResult.success(farmAdminService.getPublicKey());
    }


    @ApiOperation("密码修改")
    @PostMapping(value = "/updatePassword")
    public Object updatePassword (@RequestBody FarmPassWordVo farmPassWordVo) {
        farmAdminService.updatePassword(farmPassWordVo);
        return ResponseResult.success();
    }


    /**
     * <a href="http://localhost:9241/api/admin/userInfo">...</a>
     *
     * @param null
     * @return 返回 结果
     * @author: sutton
     * @date: 2021/6/1 10:26
     */
    @ApiOperation(value = "获取用户信息")
    @PostMapping(value = "/userInfo")
    public Object getUserInfo () {
        FarmAdminVo info = farmAdminService.getUserInfo();
        if (info == null) {
            throw new MyException("获取用户信息失败");
        }
        return ResponseResult.success(info);
    }


    /**
     * <a href="http://localhost:9241/api/admin/updateInfo">updataInfo</a>
     *
     * @param dto 用户信息
     * @return 返回修改成功的数据
     */
    @ApiOperation(value = "更新用户信息")
    @PostMapping(value = "/updateInfo")
    public Object updateInfo (@RequestBody FarmAdminInfoDto dto) {
        FarmAdminVo info = farmAdminService.updateInfo(dto);
        if (info == null) {
            throw new MyException("更新用户失败");
        }
        return ResponseResult.success(info);
    }

}
