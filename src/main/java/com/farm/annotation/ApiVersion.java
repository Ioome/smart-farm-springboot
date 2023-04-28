package com.farm.annotation;



import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;


/**
 * @name: ApiVersion
 * @description: <a href="http://localhost:8080/api/v1/user/get">...</a> <a href="http://localhost:8080/api/v1.1/user/get">...</a>
 * @date: 2023-04-26 15:50
 * @version: 1.0
 * @since JDK 1.8
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    String value ();
}
