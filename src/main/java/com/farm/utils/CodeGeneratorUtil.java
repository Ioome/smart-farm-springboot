package com.farm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CodeGeneratorUtil {
    private static int currentId = 1;  // 当前 ID，可以根据实际情况进行修改

    public static String generateCode(Long id) {
        // 获取当前时间，并将其格式化为指定的字符串格式
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timeStr = now.format(formatter);

        // 生成 UUID，并去除其中的横线
        String uuidStr = UUID.randomUUID().toString().replaceAll("-", "");

        // 获取当前 ID，并将其转换为字符串形式
        String idStr = String.valueOf(currentId);

        // 将时间、UUID 和当前 ID 组合在一起，并将其作为最终的编码
        String code = timeStr + uuidStr + idStr;
        currentId++;  // 更新当前 ID
        return code;
    }
}