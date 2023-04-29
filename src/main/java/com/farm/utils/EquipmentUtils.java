package com.farm.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @name: EquipmentUtils
 * @author: sutton
 * @date: 2023-04-29 20:03
 * @description: EquipmentUtils
 */
public class EquipmentUtils {

    /**
     * 分割字符串
     *
     * @param str       字符串
     * @param delimiter 分隔符
     * @return List<String>
     */
    public static List<String> splitString (String str, String delimiter) {
        return Arrays.stream(str.split(delimiter)).map(String::trim).collect(Collectors.toList());
    }
}
