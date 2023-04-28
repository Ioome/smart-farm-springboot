package com.farm.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.farm.entity.po.FarmAdmin;
import com.farm.mapper.FarmAdminMapper;
import com.farm.mapper.FarmPermissionMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @name: UserDetailsServiceImpl
 * @author: sutton
 * @date: 2023-04-27 12:59
 * @description: 数据库校验密码
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Resource
    private FarmAdminMapper farmAdminMapper;

    @Resource
    private FarmPermissionMapper farmPermissionMapper;

    /**
     * 校验用户
     *
     * @param username 用户名
     * @return 返回封装的对象
     * @throws UsernameNotFoundException 密码没有发现错误
     */
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        FarmAdmin user = farmAdminMapper.selectOne(new LambdaQueryWrapper<FarmAdmin>().eq(FarmAdmin::getUsername, username));
        //如果查询不到数据就通过抛出异常来给出提示
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("校验结果： 用户名或密码错误");
        }
        List<String> permsByUserIdLists = farmPermissionMapper.selectPermsByUserId(user.getId());
        return new AdminUserDetails(user, permsByUserIdLists);
    }
}
