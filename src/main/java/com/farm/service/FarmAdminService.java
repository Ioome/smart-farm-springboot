package com.farm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.farm.entity.po.FarmAdmin;
import org.springframework.stereotype.Service;

/**
 * @name: FarmAdminService
 * @author: sutton
 * @date: 2023-04-27 11:56
 * @description: 用户管理
 */
@Service
public interface FarmAdminService extends IService<FarmAdmin> {

    /**
     * 根据用户名获取后台管理员
     *
     * @param username 用户名
     * @return FarmAdmin
     */
    FarmAdmin getAdminByUsername (String username);

    /**
     * 注册功能
     *
     * @param umsAdminParam 用户参数
     * @return FarmAdmin
     */
    FarmAdmin register (FarmAdmin umsAdminParam);


    /**
     * 登录功能
     *
     * @param farmAdmin 用户参数
     * @return token
     */
    String login (FarmAdmin farmAdmin);

    /**
     * 登出功能
     */
    void logout ();
}
