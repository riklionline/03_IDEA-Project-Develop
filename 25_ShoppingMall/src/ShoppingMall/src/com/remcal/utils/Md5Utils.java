package com.remcal.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class Md5Utils {

    public static void main(String[] args) {
        String s = md5("123456");
        //e10adc3949ba59abbe56e057f20f883e
        System.out.println(s);
    }
    public static String md5(String str){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("utf-8"));
            byte[] digest = messageDigest.digest();
            BigInteger bigInteger=new BigInteger(1, digest);
            return bigInteger.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
