package com.proxypattern;

/**
 * 主题(subject):售票
 * 将出票抽象为一种行为动作，定义为接口
 */
public interface TicketMaster {
    public void sell();
}
