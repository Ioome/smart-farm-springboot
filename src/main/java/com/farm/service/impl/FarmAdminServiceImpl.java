package com.farm.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.farm.entity.dto.FarmAdminInfoDto;
import com.farm.entity.po.FarmAdmin;
import com.farm.entity.vo.FarmAdminVo;
import com.farm.entity.vo.FarmPassWordVo;
import com.farm.exception.FarmExceptionEnum;
import com.farm.exception.MyException;
import com.farm.mapper.FarmAdminMapper;
import com.farm.service.FarmAdminService;
import com.farm.service.admin.AdminUserDetails;
import com.farm.utils.JwtUtil;
import com.farm.utils.RSAUtil;
import com.farm.utils.RedisCache;
import com.farm.utils.UserInfoUtils;
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

import static java.util.Objects.isNull;

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

        String finalPassWord = RSAUtil.decryptBase64(umsAdminParam.getPassword().trim());
        FarmAdmin farmAdmin = new FarmAdmin();
        BeanUtils.copyProperties(umsAdminParam, farmAdmin);
        farmAdmin.setCreatedTime(new Date());
        farmAdmin.setStatus(1);
        List<FarmAdmin> umsAdminList = adminMapper.selectList(new QueryWrapper<FarmAdmin>().lambda().eq(FarmAdmin::getUsername, umsAdminParam.getUsername()));
        if (!umsAdminList.isEmpty()) {
            throw new MyException(FarmExceptionEnum.NAME_EXISTED.getCode(), "该用户名已存在");
        }
        String encodePassword = passwordEncoder.encode(finalPassWord);
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
        if (StrUtil.isBlank(farmAdmin.getPassword().trim())) {
            throw new MyException("密码为空，请重新输入密码");
        }
        String finalPassWord = RSAUtil.decryptBase64(farmAdmin.getPassword().trim());
        //记录秒数
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(farmAdmin.getUsername(), finalPassWord);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (isNull(authenticate)) {
            throw new MyException("账户或密码错误");
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
        redisCache.deleteObject("token_" + userid);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param farmAdmin
     * @return 返回用户信息
     */
    @Override
    public FarmAdminVo getUserInfo () {
        Long userId = UserInfoUtils.getUserId();
        FarmAdmin farmAdmin1 = adminMapper.selectOne(new QueryWrapper<FarmAdmin>().lambda().eq(FarmAdmin::getId, userId));
        if (isNull(farmAdmin1)) {
            throw new MyException("用户不存在");
        }
        FarmAdminVo farmAdminVo = new FarmAdminVo();
        BeanUtils.copyProperties(farmAdmin1, farmAdminVo);
        LOGGER.info("用户 {}", farmAdminVo);
        return farmAdminVo;
    }

    @Override
    public FarmAdminVo updateInfo (FarmAdminInfoDto dto) {
        Long userId = UserInfoUtils.getUserId();
        FarmAdmin farmAdmin = adminMapper.selectOne(new QueryWrapper<FarmAdmin>().lambda().eq(FarmAdmin::getId, userId));
        if (isNull(farmAdmin)) {
            throw new MyException("用户不存在或者未登录");
        }
        farmAdmin.setUsername(dto.getUsername());
        farmAdmin.setNickName(dto.getNickName());
        farmAdmin.setPhone(dto.getPhone());
        farmAdmin.setEmail(dto.getEmail());
        farmAdmin.setSex(dto.getSex());
        farmAdmin.setEmail(dto.getEmail());
        farmAdmin.setNote(dto.getNote());
        FarmAdminVo farmAdminVo = new FarmAdminVo();
        BeanUtils.copyProperties(farmAdmin, farmAdminVo);
        adminMapper.updateById(farmAdmin);
        LOGGER.info("用户 {}", farmAdmin);
        return farmAdminVo;
    }

    /**
     * 修改用户名密码
     */
    @Override
    public void updatePassword (FarmPassWordVo farmPassWordVo) {
        Long userId = UserInfoUtils.getUserId();
        String oldP = RSAUtil.decryptBase64(farmPassWordVo.getOldPassword().trim());
        String newP = RSAUtil.decryptBase64(farmPassWordVo.getNewPassword().trim());
        if (CharSequenceUtil.isBlank(oldP) || CharSequenceUtil.isBlank(newP)) {
            throw new MyException("旧密码或新密码为空");
        }

        FarmAdmin farmAdmin = adminMapper.selectOne(new QueryWrapper<FarmAdmin>().lambda().eq(FarmAdmin::getId, userId));
        boolean matches = passwordEncoder.matches(oldP, farmAdmin.getPassword());
        if (!matches) {
            LOGGER.info("旧密码错误");
            throw new MyException(FarmExceptionEnum.WRONG_PASSWORD.getCode(), FarmExceptionEnum.WRONG_PASSWORD.getMessage());
        }
        String encode = passwordEncoder.encode(newP);
        LOGGER.info(encode);
        int update = adminMapper.update(null, new UpdateWrapper<FarmAdmin>().lambda().eq(FarmAdmin::getId, userId).set(FarmAdmin::getPassword, encode));
        if (update <= 0) {
            throw new MyException("修改失败");
        }
    }

    /**
     * 生成公钥
     *
     * @return 生成公钥
     */
    @Override
    public String getPublicKey () {
        return RSAUtil.generateBase64PublicKey();
    }
}
