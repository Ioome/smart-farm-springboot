package com.farm.utils;

import com.farm.enums.ResponseStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @name: ResponseResult
 * @author: sutton
 * @date: 2023-04-26 16:28
 * @description: ResponseResult
 */
@Data
@Builder
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * response timestamp.
     */

    private long timestamp;

    /**
     * response code, 200 -> OK.
     */

    private String status;


    private String message;

    /**
     * response data.
     */

    private T data;

    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success () {
        return success(null);
    }

    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success (T data) {
        return ResponseResult.<T>builder().data(data).message(ResponseStatus.SUCCESS.getDescription()).status(ResponseStatus.SUCCESS.getResponseCode()).timestamp(System.currentTimeMillis()).build();
    }

    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail (String message) {
        return fail(null, message);
    }

    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> fail (T data, String message) {
        return ResponseResult.<T>builder().data(data).message(message).status(ResponseStatus.FAIL.getResponseCode()).timestamp(System.currentTimeMillis()).build();
    }

    @Override
    public String toString () {
        return "ResponseResult{" + "timestamp=" + timestamp + ", status='" + status + '\'' + ", message='" + message + '\'' + ", data=" + data + '}';
    }
}
