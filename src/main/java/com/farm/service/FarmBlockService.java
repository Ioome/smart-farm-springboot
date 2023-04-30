package com.farm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.entity.dto.FarmBlockDto;
import com.farm.entity.po.FarmBlock;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sutton
 * @version 0.0.1
 * @date 2021/06/19 10:04:18
 * @description FarmBlockService 接口
 * @since 0.0.1
 */
@Service
public interface FarmBlockService extends IService<FarmBlock> {


    /**
     * 获取所有农田
     *
     * @return 农田列表
     */
    List<FarmBlock> getAll ();


    /**
     * 根据id获取农田
     *
     * @param id id 信息
     * @return 农田个别信息
     */
    FarmBlock getOne (Long id);


    /**
     * 根据 id 删除
     *
     * @param id
     * @return 返回删除后的信息
     */
    Object deleteById (Integer id) throws Exception;


    /**
     * 分页查询区块
     *
     * @param dto 分页信息
     * @return 区块列表List
     */
    List<FarmBlock> getBlockList (FarmBlockDto dto);
}