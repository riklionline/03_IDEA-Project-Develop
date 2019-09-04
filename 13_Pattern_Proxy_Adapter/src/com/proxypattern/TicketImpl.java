package com.proxypattern;

/**
 * 接口实现类
 */
public class TicketImpl implements TicketMaster {
    @Override
    public void sell() {
        System.out.println("出票:《BEYOND·1990》演唱会，1张");
    }
}
