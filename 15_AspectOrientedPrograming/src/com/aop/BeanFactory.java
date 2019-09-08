package com.aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BeanFactory {

    Properties properties = new Properties();

    public BeanFactory(InputStream in){
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String name){
        String className = properties.getProperty(name);
        Object bean = null;
        try {

            Class<?> aClass = Class.forName(className);
            bean = aClass.newInstance();

            Object target = Class.forName(properties.getProperty(name + ".target")).newInstance();
            Object advice = Class.forName(properties.getProperty(name + ".advice")).newInstance();

            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor pd:propertyDescriptors) {
                String propertyName = pd.getName();
                Method writeMethod = pd.getWriteMethod();
                if("target".equals(propertyName)){
                    writeMethod.invoke(bean,target);

                }else if("advice".equals(propertyName)){
                    writeMethod.invoke(bean,advice);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

}
