package com.feige.init.utils;

import java.util.UUID;

/**
 * MrLiu253@163.com
 *
 * @time 2/9/22
 * 描述:
 */
public class ToolUtils {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
