package com.aop;

import java.io.InputStream;

public class Run {
    public static void main(String[] args) {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/aop/bean.properties");
        BeanFactory beanFactory = new BeanFactory(in);
        ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory.getBean("bean");

        IService proxy = (IService) proxyFactoryBean.getProxy();
        proxy.getMoney();

    }
}
