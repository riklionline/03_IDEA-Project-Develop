package com.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 定义"代理"的接口实现类
 */
public class ProxyFactory implements InvocationHandler {

    private Object target;//"被"代理的对象

    public Object create(Object target){//创建代理对象的方法
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxy;//将创建的代理对象返回
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始选票");
        System.out.println("付款完成");
        method.invoke(target,args);//此处准备调用的是被代理对象的方法（TicketImpl-sell()），业务功能是出票
        System.out.println("售票完成");
        return null;
    }
}
