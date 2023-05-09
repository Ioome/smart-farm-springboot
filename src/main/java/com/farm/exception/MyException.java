package com.farm.exception;


import com.farm.restful.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.validation.BindingResult;

/**
 * @Author: LoveHuahua
 * @Date: 2021/3/6 14:58
 * @Description: just do IT 要么第一个做，要么做最好-> believe in yourself.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MyException extends RuntimeException {

  private int code;
  private String message;
  private Exception e;

  /**
   * Constructs a new runtime exception with {@code null} as its detail message.  The cause is not
   * initialized, and may subsequently be initialized by a call to {@link #initCause}.
   */
  public MyException(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public MyException(int code, Exception e) {
    this.code = code;
    this.e = e;
  }

  public MyException(String message, Exception e) {
    this.message = message;
    this.e = e;
  }

  public MyException(ErrorCode errorCode) {
    this.code = errorCode.getCode();
    this.message = errorCode.getDesc();
  }

  public MyException(FarmExceptionEnum exceptionEnum,Exception e)
  {
    this.code=exceptionEnum.getCode();
    this.message=exceptionEnum.getMessage();
    this.e=e;
  }
  public MyException(String message) {
    this.message = message;
  }
  public MyException(BindingResult bindingResult) {
    this.message = bindingResult.getAllErrors().get(0) == null ? "参数错误" : bindingResult.getAllErrors().get(0).getDefaultMessage();
  }
}
