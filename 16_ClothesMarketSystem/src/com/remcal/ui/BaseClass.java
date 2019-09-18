package com.remcal.ui;

import com.remcal.bean.User;
import com.remcal.framework.BeanFactory;

import java.util.ResourceBundle;
import java.util.Scanner;


public abstract class BaseClass {
    protected static Scanner input = new Scanner(System.in);
    protected static User currUser;//当前用户对象
    protected BeanFactory beanFactory = null;
    private static ResourceBundle r =
            ResourceBundle.getBundle("com.remcal.res.r");

    public static String getString(String key){
        return r.getString(key);
    }

    public static void println(String s){
        System.out.println(s);
    }

    public static void print(String s){
        System.out.print(s);
    }

    public BaseClass(){
        beanFactory = BeanFactory.init();
    }
}
