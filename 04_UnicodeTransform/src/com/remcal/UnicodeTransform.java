package com.remcal;
/**
 *
 * @company Foundation of Art and Technology
 * @author Remcal
 * @description chinese to unicode or unicode to chinese
 * Aug 2, 2019
 */
public class UnicodeTransform{

    public static void main(String[] args) {
        String name1="\\u5c11\\u5e74\\u672a\\u8c19\\u4e16\\u4e8b\\u96be\\uff0c";
        String name2="\\u8001\\u5927\\u5e94\\u6765\\u5ea6\\u91cd\\u5173\\u3002";
        String name3="\\u4eba\\u751f\\u81ea\\u5f53\\u65e0\\u7a77\\u5c3d\\uff0c";
        String name4="\\u957f\\u53f9\\u4f55\\u5fc5\\u5728\\u4eba\\u95f4\\u3002";
        System.out.println(unicodeToCn(name1));
        System.out.println(unicodeToCn(name2));
        System.out.println(unicodeToCn(name3));
        System.out.println(unicodeToCn(name4));
    }

    //unicode to chinese
    private static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }
    //chinese to unicode
    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }
}

