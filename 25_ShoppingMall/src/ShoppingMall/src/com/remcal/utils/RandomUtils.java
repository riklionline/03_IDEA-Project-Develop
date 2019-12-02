package com.remcal.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class RandomUtils {
    //当前时间 + 随机数
    public static String createActive(){

        return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
    }
    public static String getTime(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
    }
    //生成订单编号
    public static String createOrderId(){
        return getTime();
    }
}
