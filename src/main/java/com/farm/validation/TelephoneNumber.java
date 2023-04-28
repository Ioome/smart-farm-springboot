package com.farm.validation;

import com.farm.validation.impl.TelephoneNumberImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @name: TelephoneNumber
 * @author: sutton
 * @date: 2023-04-26 16:44
 * @description: TelephoneNumber
 */

@Target(value = {METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {TelephoneNumberImpl.class})
public @interface TelephoneNumber {
    String message () default "Invalid telephone number";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
