package com.remcal.utils;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class StringUtils {
    public static  boolean isEmpty(String str){
        if(str==null||str.trim().length()==0){
            return true;
        }
        return false;
    }
}
