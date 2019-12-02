package com.remcal.utils;

import java.util.Base64;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
//base64 加密 解密 激活邮件的时候 为 邮箱地址 code验证码 进行加密
//当 回传回来后 进行邮箱地址 和 code 的解密
public class Base64Utils {
    //加密
    public static String encode(String msg){
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
    //解密
    public static String decode(String msg){
        return new String(Base64.getDecoder().decode(msg));
    }
}