package com.farm.validation.impl;

import com.farm.validation.TelephoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @name: TelephoneNumberImpl
 * @author: sutton
 * @date: 2023-04-26 16:45
 * @description: 电话号码校验器
 */
public class TelephoneNumberImpl implements ConstraintValidator<TelephoneNumber, String> {
    private static final String REGEX_TEL = "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}";

    @Override
    public boolean isValid (String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return Pattern.matches(REGEX_TEL, s);
        } catch (Exception e) {
            return false;
        }
    }
}
