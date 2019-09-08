package com.proxypattern;

public class Run {
    public static void main(String[] args) {

        ProxyFactory pf = new ProxyFactory();//创建代理对象
        TicketMaster ticket = new TicketImpl();//创建被代理对象
        TicketMaster proxy = (TicketMaster) pf.create(ticket);//将被代理对象放入创建代理对象的方法中，启动动态代理
        proxy.sell();
    }
}
