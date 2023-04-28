package com.farm.handler;

import com.alibaba.fastjson.JSON;
import com.farm.utils.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @name: RestfulAccessDeniedHandler
 * @author: sutton
 * @date: 2023-04-27 23:22
 * @description: 当访问接口没有权限时，自定义的返回结果
 * Created by macro on 2018/4/26.
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle (HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        String json = JSON.toJSONString(ResponseResult.fail(HttpStatus.UNAUTHORIZED.value(), "认证失败请重新登录"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(json);
        response.getWriter().flush();
    }
}
