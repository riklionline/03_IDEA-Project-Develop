package com.singletonparrern;

public class SingletonDemo {
    public static void main(String[] args) {
        SingletonHungry sh = SingletonHungry.getSingletonHungry();
        sh.print();

        SingletonLazy sl = SingletonLazy.getSingletonLazy();
        sl.print();
    }
}

class SingletonHungry{
    private SingletonHungry(){}
    private static SingletonHungry singletonHungry = new SingletonHungry();
    public static SingletonHungry getSingletonHungry(){
        return singletonHungry;
    }
    public void print(){
        System.out.println("this is the hungry singleton design pattern");
    }
}

class SingletonLazy{
    private SingletonLazy(){}
    private static SingletonLazy singletonLazy;
    public static SingletonLazy getSingletonLazy(){
        if(singletonLazy==null){
            synchronized(SingletonLazy.class){
                if(singletonLazy==null){
                    singletonLazy=new SingletonLazy();
                }
            }
        }
        return singletonLazy;
    }
    public void print(){
        System.out.println("this is the lazy singleton design pattern");
    }
}
