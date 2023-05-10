package com.farm.aspect;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.farm.entity.po.FarmAdmin;
import com.farm.mapper.FarmAdminMapper;
import com.farm.utils.UserInfoUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pdai
 */
@EnableAspectJAutoProxy
@Component
@Aspect
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Resource
    private FarmAdminMapper farmAdminMapper;

    /**
     * define point cut.
     */
    @Pointcut("execution(* com.farm.service.*.*(..))")
    private void pointCutMethod () {
    }


    @Around("pointCutMethod()")
    public Object logMethodExecutionTime (ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Method " + joinPoint.getSignature().getName() + " started");

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        logger.info("Method " + joinPoint.getSignature().getName() + " ended");
        logger.info("Method " + joinPoint.getSignature().getName() + " execution time : " + (endTime - startTime) / 1000 + "ms");
        // 获取方法签名和参数列表
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();

        // 构造日志信息
        Map<String, Object> logInfo = new HashMap<>();
        logInfo.put("methodName", method.getName());
        logInfo.put("className", method.getDeclaringClass().getSimpleName());
        logInfo.put("requestParams", Arrays.toString(args));
        logInfo.put("response", result == null ? "null" : result);
        logInfo.put("errorMessage", result == null ? "null" : "");
        logInfo.put("timestamp", new Date());
        logInfo.put("executionTime", endTime - startTime);
        // 输出日志信息
        logger.info(new ObjectMapper().writeValueAsString(logInfo));
        return result;
    }

    /**
     * 前置通知.
     */
    @Before("pointCutMethod()")
    public void doBefore () {
        logger.info("方法开始执行...............");
    }


    /**
     * 后置通知.
     *
     * @param result return val
     */
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning (String result) {
        logger.info("后置通知, 返回值: " + result);
    }

    /**
     * 异常通知.
     *
     * @param e exception
     */
    @AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
    public void doAfterThrowing (Exception e) {
        logger.info("异常通知, 异常: " + e.getMessage());
    }


}
