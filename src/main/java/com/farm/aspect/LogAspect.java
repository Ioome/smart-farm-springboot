package com.farm.aspect;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author pdai
 */
@EnableAspectJAutoProxy
@Component
@Aspect
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

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
        logger.info("Method " + joinPoint.getSignature().getName() + " execution time : " + (endTime - startTime) + "ms");

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
