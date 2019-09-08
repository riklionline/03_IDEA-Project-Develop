package com.aop;

public class ServiceImpl implements IService {

    @Override
    public void getMoney() {
        System.out.println("输入密码");
        System.out.println("输入金额");
        System.out.println("开始取款");
        System.out.println("结束交易");

    }
}
