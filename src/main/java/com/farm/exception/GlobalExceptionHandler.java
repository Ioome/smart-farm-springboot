package com.farm.exception;

import com.farm.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @name: MyExceptionHandler
 * @author: sutton
 * @date: 2023-04-30 14:04
 * @description: MyExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exceptionHandler (Exception e) {
        logger.info("全局异常捕获>>> {}", e);
        return ResponseResult.fail(FarmExceptionEnum.NAME_EXISTED.getCode(), FarmExceptionEnum.NAME_EXISTED.getMessage());
    }
}
