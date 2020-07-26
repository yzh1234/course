package com.yzh.course.util;


import org.springframework.util.DigestUtils;

public class MD5 {
    public static String md5(String text, String key) throws Exception {
        String saltKey=key+text;
        return DigestUtils.md5DigestAsHex(saltKey.getBytes());
    }
    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equalsIgnoreCase(md5)) {
            return true;
        }
        return false;
    }
}
