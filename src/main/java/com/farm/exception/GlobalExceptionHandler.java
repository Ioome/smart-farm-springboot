package com.farm.exception;

import com.farm.restful.ResultModel;
import com.farm.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @name: MyExceptionHandler
 * @author: sutton
 * @date: 2023-04-30 14:04
 * @description: MyExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException (Exception e) {
        log.error(e.getLocalizedMessage(), e);
        log.error("Default Exception: ", e);
        return ResponseResult.fail(e, e.getMessage());
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Object handleException (MyException e) {
        log.error("MyException: ", e);
        return ResponseResult.fail(e.getMessage());
    }


    /**
     * 处理请求参数格式错误 @RequestBody上使用@Valid 实体上使用@NotNull等，验证失败后抛出的异常是MethodArgumentNotValidException异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultModel MethodArgumentNotValidExceptionHandler (MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultModel
                .error(message);
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultModel BindExceptionHandler (BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultModel
                .error(message);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResultModel ConstraintViolationExceptionHandler (ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return ResultModel
                .error(message);
    }

    /**
     * 参数格式异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultModel HttpMessageNotReadableExceptionHandler (HttpMessageNotReadableException e) {
        return ResultModel
                .error("参数格式异常");
    }
}
