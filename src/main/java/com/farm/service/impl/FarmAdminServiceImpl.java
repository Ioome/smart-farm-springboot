package com.farm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.po.FarmAdmin;
import com.farm.exception.MyException;
import com.farm.mapper.FarmAdminMapper;
import com.farm.service.FarmAdminService;
import com.farm.service.admin.AdminUserDetails;
import com.farm.utils.JwtUtil;
import com.farm.utils.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @name: FarmAdminServiceImpl
 * @author: sutton
 * @date: 2023-04-27 11:56
 * @description: FarmAdminServiceImpl
 */

@Service
public class FarmAdminServiceImpl extends ServiceImpl<FarmAdminMapper, FarmAdmin> implements FarmAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FarmAdminServiceImpl.class);

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    @Resource
    private FarmAdminMapper adminMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 根据用户名获取后台管理员
     *
     * @param username 用户名
     */
    @Override
    public FarmAdmin getAdminByUsername (String username) {
        return null;
    }

    /**
     * 注册功能
     *
     * @param umsAdminParam umsAdminParam
     */
    @Override
    public FarmAdmin register (FarmAdmin umsAdminParam) {
        FarmAdmin farmAdmin = new FarmAdmin();
        BeanUtils.copyProperties(umsAdminParam, farmAdmin);
        farmAdmin.setCreatedTime(new Date());
        farmAdmin.setStatus(1);
        List<FarmAdmin> umsAdminList = adminMapper.selectList(new QueryWrapper<FarmAdmin>().lambda().eq(FarmAdmin::getUsername, umsAdminParam.getUsername()));
        if (!umsAdminList.isEmpty()) {
            throw new MyException("该用户名已存在");
        }
        String encodePassword = passwordEncoder.encode(farmAdmin.getPassword());
        farmAdmin.setPassword(encodePassword);
        adminMapper.insert(farmAdmin);
        return umsAdminParam;
    }


    /**
     * 登录功能
     *
     * @param farmAdmin 用户参数
     * @return token
     */
    @Override
    public String login (FarmAdmin farmAdmin) {
        long start = System.currentTimeMillis();
        LOGGER.info("用户开始登录............");
        //记录秒数
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(farmAdmin.getUsername(), farmAdmin.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //登录时间
        AdminUserDetails finalUser = (AdminUserDetails) authenticate.getPrincipal();

        //修改登录时间
        Long userId = finalUser.getUser().getId();
        String token = JwtUtil.createJWT(String.valueOf(userId));
        LOGGER.info("时间 {}, 放入 redis", new Date());
        redisCache.setCacheObject("token_" + userId, finalUser);
        long end = System.currentTimeMillis();
        LOGGER.info("用户登录成功............");
        LOGGER.info("登录耗时：{}", end - start);
        return token;
    }

    /**
     *
     */
    @Override
    public void logout () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AdminUserDetails loginUser = (AdminUserDetails) authentication.getPrincipal();
        if (loginUser == null) {
            throw new RuntimeException("退出失败");
        }
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject("token_:" + userid);
    }
}
