package com.farm.controller;

import com.farm.entity.po.FarmAdmin;
import com.farm.entity.po.FarmBlock;
import com.farm.exception.FarmExceptionEnum;
import com.farm.service.FarmBlockService;
import com.farm.utils.ResponseResult;
import com.farm.validation.group.RegisterGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @name: FarmBlockController
 * @author: sutton
 * @date: 2023-04-30 14:37
 * @description: FarmBlockController
 */
@Slf4j
@RestController
@RequestMapping("/api/block")
public class FarmBlockController {

    @Autowired
    private FarmBlockService farmBlockService;


    /**
     * <a href="http://localhost:9241/api/block/getAll">返回区块</a>
     *
     * @return Lists
     */
    @ApiOperation(value = "所有区块")
    @GetMapping(value = "/getAll")
    public Object getAll () {
        List<FarmBlock> farmBlocksListAll = farmBlockService.getAll();
        if (farmBlocksListAll == null) {
            ResponseResult.fail(FarmExceptionEnum.LOGIN_ERROR.getMessage());
        }
        return ResponseResult.success(farmBlocksListAll);
    }


    /**
     * <a href="http://localhost:9241/api/block/getOne">返回区块</a>
     *
     * @param farmBlock     区块信息
     * @param bindingResult 校验结果
     * @return block
     */
    @ApiOperation(value = "返回某个区块的信息")
    @GetMapping(value = "/getOne")
    public Object getOne (@RequestBody FarmBlock farmBlock, BindingResult bindingResult) {
        FarmBlock block = farmBlockService.getOne(farmBlock.getId());
        return ResponseResult.success(block);
    }


    /**
     * <a href="http://localhost:9241/api/block/register">新增区块</a>
     *
     * @param farmBlock     区块信息
     * @param bindingResult 校验结果
     * @return block
     */
    @ApiOperation(value = "添加区块")
    @PostMapping(value = "/add")
    public Object add (@RequestBody FarmBlock farmBlock, BindingResult bindingResult) {
        farmBlockService.save(farmBlock);
        return ResponseResult.success(null);
    }


    /**
     * <a href="http://localhost:9241/api/block/delete">...</a>
     *
     * @param id 逻辑删除
     * @return block
     */
    @RequestMapping("/delete")
    public Object delete (Integer id) {
        return farmBlockService.deleteById(id);
    }
}
