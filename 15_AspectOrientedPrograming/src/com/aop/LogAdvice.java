package com.aop;

public class LogAdvice implements Advice {
    @Override
    public void beforeAdvice() {
        System.out.println("start:"+System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("end:"+System.currentTimeMillis());
    }
}
