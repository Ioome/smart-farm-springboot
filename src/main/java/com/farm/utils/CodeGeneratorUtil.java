package com.farm.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class CodeGeneratorUtil {
    private static int currentId = 1;

    //为我声明一个字符串数组
    //耕地 01 园地 02
    private static String[] CHIMA_CODE = {"0101", "0102", "0103", "0201", "0202", "0203", "0204"};
    private static final String PREFIX = "LJ";
    private static final String SEPARATOR = "_";

    public static String generateCode (Long currentId) {
        // 获取当前时间，并将其格式化为指定的字符串格式
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timeStr = now.format(formatter);


        // 获取当前 ID，并将其转换为字符串形式
        String idStr = String.valueOf(currentId);

        // 将时间、UUID 和当前 ID 组合在一起，并将其作为最终的编码
        String code = timeStr + idStr;
        currentId++;  // 更新当前 ID
        return code;
    }


    public static String generateLandCode () {
        // 生成时间戳
        String timestamp = new SimpleDateFormat("yyyy-MM-dd-").format(new Date());


        // 生成当前 ID
        String id = String.format("%03d", currentId++);

        String code = CHIMA_CODE[pickRandomIndex(CHIMA_CODE.length)];

        // 拼接土地编码
        return PREFIX + timestamp + code + SEPARATOR + id;
    }

    public static int pickRandomIndex (int size) {
        Random random = new Random();
        return random.nextInt(size);
    }


}