package com.farm.service.admin;

import com.alibaba.fastjson.annotation.JSONField;
import com.farm.entity.po.FarmAdmin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @name: LoginUser
 * @author: sutton
 * @date: 2023-04-27 13:04
 * @description: LoginUser
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminUserDetails implements UserDetails {


    private FarmAdmin user;

    /**
     * 存储权限信息
     */
    private List<String> permissions;


    @JSONField(serialize = false)
    private List<GrantedAuthority> authorities;

    public AdminUserDetails (FarmAdmin user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    public FarmAdmin getUser () {
        return user;
    }

    public void setUser (FarmAdmin user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        if (authorities != null) {
            return authorities;
        }
        //把permissions中字符串类型的权限信息转换成GrantedAuthority对象存入authorities中
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword () {
        return user.getPassword();
    }

    @Override
    public String getUsername () {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return true;
    }
}
