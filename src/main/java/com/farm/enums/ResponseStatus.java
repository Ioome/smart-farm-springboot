package com.farm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @name: ResponseStatus
 * @author: sutton
 * @date: 2023-04-26 16:24
 * @description: 统一返回方便前端进行开发和封装，以及出现时给出响应编码和信息。
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {

    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 200  describe success
     */
    SUCCESS("200", "success"),


    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 500  describe failed
     */
    FAIL("500", "failed"),


    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 200  describe okk
     */
    HTTP_STATUS_200("200", "ok"),

    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 400  describe request error
     */
    HTTP_STATUS_400("400", "request error"),

    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 401  describe rno authentication
     */
    HTTP_STATUS_401("401", "no authentication"),


    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 403  describe no authorities
     */
    HTTP_STATUS_403("403", "no authorities"),

    /**
     * @description: ResponseStatus
     * @name: ResponseStatus
     * @param: [responseCode, description]
     * @return: 500  describe server error
     */
    HTTP_STATUS_500("500", "server error");

    public static final List<ResponseStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(Arrays.asList(HTTP_STATUS_200, HTTP_STATUS_400, HTTP_STATUS_401, HTTP_STATUS_403, HTTP_STATUS_500));

    /**
     * response code
     */
    private final String responseCode;

    /**
     * description.
     */
    private final String description;

}
