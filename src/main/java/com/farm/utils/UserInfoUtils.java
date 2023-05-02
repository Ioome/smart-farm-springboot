package com.farm.utils;

import com.farm.service.admin.AdminUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @name: UserInfoUtils
 * @author: sutton
 * @date: 2023-05-02 17:02
 * @description: UserInfoUtils
 */


@Component
public class UserInfoUtils {
    /**
     * 获取用户信息
     *
     * @return 返回已经登录的用户id
     */
    public static Long getUserId () {
        AdminUserDetails user = (AdminUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUser().getId();
    }
}
