package com.farm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.entity.po.FarmBlock;
import org.springframework.stereotype.Service;

import java.util.List;

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
    Object deleteById (Integer id);
}