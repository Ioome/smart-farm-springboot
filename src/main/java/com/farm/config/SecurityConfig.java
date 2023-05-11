package com.farm.config;

import com.farm.filter.JwtAuthenticationTokenFilter;
import com.farm.handler.RestAuthenticationEntryPoint;
import com.farm.handler.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @name: SecurityConfig
 * @author: sutton
 * @date: 2023-04-27 13:22
 * @version: 1.1.0
 * @description: SecurityConfig
 * @description: 认证与权限控制
 * @since JDK 1.8
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * @description: 用于配置需要拦截的url路径、jwt过滤器
     */
    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    /**
     * @description: 用于处理认证失败（token错误）的类
     */
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    /**
     * @description: 用于处理认证失败（无token）的类
     */
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    /**
     * @return org.springframework.security.crypto.password.PasswordEncoder
     * @description: 解决数据库 {noop},解决请求密钥参数与数据库注册后加密数据对比
     */
    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }


    /**
     * @return org.springframework.security.authentication.AuthenticationManager
     * @throws Exception 异常
     * @description: 用于支持 password 模式
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean () throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * @param http http 请求
     * @throws Exception 异常
     * @description 配置 security
     */
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        // 使用JWT，不需要csrf
        http.csrf()
                .disable()
                // 基于token，所以不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许对于网站静态资源的无授权访问
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                .antMatchers("/api/admin/login", "/api/admin/register", "/api/admin/logout","/api/admin/getPublicKey")
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
//                .antMatchers("/**")//测试时全部运行访问
//                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        //把token校验过滤器添加到过滤器链中
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
        http.cors().disable();
    }
}
