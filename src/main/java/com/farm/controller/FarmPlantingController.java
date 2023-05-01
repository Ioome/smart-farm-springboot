package com.farm.controller;

import com.farm.entity.dto.FarmPlantingDto;
import com.farm.entity.po.FarmPlanting;
import com.farm.service.FarmPlantingService;
import com.farm.utils.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author sutton
 * @description 种植计划表controller层
 * @date 2023-05-01
 */
@Slf4j
@RestController
@RequestMapping("/api/planting")
public class FarmPlantingController {


    @Resource
    private FarmPlantingService farmPlantingService;

    /**
     * 新增
     *
     * @author zhengkai.blog.csdn.net
     * @date 2023/05/01
     **/
    @RequestMapping("/insert")
    public Object insert (FarmPlanting farmPlanting) {
        return farmPlantingService.insert(farmPlanting);
    }

    /**
     * 刪除
     *
     * @author zhengkai.blog.csdn.net
     * @date 2023/05/01
     **/
    @RequestMapping("/delete")
    public Object delete (int id) {
        return farmPlantingService.delete(id);
    }

    /**
     * 更新
     *
     * @author zhengkai.blog.csdn.net
     * @date 2023/05/01
     **/
    @RequestMapping("/update")
    public Object update (FarmPlanting farmPlanting) {
        return farmPlantingService.update(farmPlanting);
    }

    /**
     * 查询 根据主键 id 查询
     *
     * @author zhengkai.blog.csdn.net
     * @date 2023/05/01
     **/
    @RequestMapping("/load")
    public Object load (FarmPlantingDto param) {
        return farmPlantingService.load(param.getId());
    }

    /**
     * 查询 分页查询
     *
     * @author zhengkai.blog.csdn.net
     * @date 2023/05/01
     **/
    @RequestMapping("/pageList")

    public Map<String, Object> pageList (@RequestBody FarmPlantingDto dto) {
        return farmPlantingService.pageList(dto);
    }
}



