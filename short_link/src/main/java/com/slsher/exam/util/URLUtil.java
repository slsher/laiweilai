package com.slsher.exam.util;

import java.util.Random;

/**
 * @program: laiweilai
 * @description:
 * @author: zhuzhiwen
 * @date: 2023/02/22 22:06
 **/
public class URLUtil {
    //生成短链接的八个字符
    public static String getShortURL() {
        Random random = new Random();

        // 要使用生成 URL 的字符
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        int cl = chars.length;
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 8; ++i) {
            key.append(chars[random.nextInt(cl)]);
        }

        return key.toString();
    }
}
