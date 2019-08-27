package com.remcal;

/**
 * 编码步骤描述
 * Step1：定义食物类Class Food；
 * Step2：定义生产者与消费者线程，操作对象为食物类Food；
 * Step3：主函数调用线程测试运行结果；
 */

public class ProducterConsumerDemo {
    public static void main(String[] args) {
        Food food = new Food();
        Producter Pro = new Producter(food);
        Consumer Con = new Consumer(food);
        Thread TPro = new Thread(Pro);
        Thread TCon = new Thread(Con);
        TPro.start();
        TCon.start();
    }
}

/*生产者线程类*/
class Producter implements Runnable {
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        /*生产20盘菜，一共两种菜交替生产*/
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                food.set("白米馒头粥", "清淡");
            } else {
                food.set("冰镇素水饺", "快捷");
            }
            System.out.println("正在炒菜……"+Thread.currentThread());
        }
    }
}

/*消费者线程类*/
class Consumer implements Runnable {
    private Food food;

    public Consumer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        /*消费20盘菜，两种菜有哪个就消费哪个*/
        for (int i = 0; i < 20; i++) {
            food.get();
        }
    }
}

/**
 * 定义食物类
 * 原则：谁拥有数据，谁定义方法，故操作食物类中的数据的方法（存值&取值）在此定义完成
 */
class Food {

    private String name;  //食物名称
    private String desc;  //食物描述
    private boolean flag = true;//true 表示可以生产，false表示可以消费

    /**
     * 生产食物(存值)
     * @ param name
     * @ param desc
     */
    public void set(String name, String desc) {
        synchronized (this) {//对象上锁，synchronized()表示这个对象一次只能被一个方法使用，抢占资源
            /*flag为false表示不可以生产，可以消费，故需要让出CPU时间片，同时对象解锁，允许其他线程操作此对象*/
            if (!flag) {
                try {
                    this.wait();//解锁+释放CPU时间片
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            /*flag为true表示可以生产，利用CPU分配的时间片，开始处理数据，注意此时对象为上锁状态*/
            this.name = name;//正在生产,产生了一个菜名
            /*此处代码是为了增加延时500ms，模拟真实的做菜场景*/
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.desc = desc;//正在生产，产生了一个描述
            flag = false;//生产完成，生产机制的标志位切换
            this.notify();//生产完成，唤醒此对象锁上的其他任意一个线程
        }
    }

    /**
     * 消费食物（取值）
     *
     * @ para name
     * @ para desc
     */
    public void get() {
        synchronized (this) {//对象上锁，synchronized()表示这个对象一次只能被一个方法使用，抢占资源
            /*flag为true表示不可以消费，故需要让出CPU时间片，同时对象解锁，允许其他线程操作此对象*/
            if (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("正在上菜……"+Thread.currentThread()+this.name + "---" + this.desc);//正在消费，输出一个菜名和一个描述
            flag = true;
            this.notify();//唤醒此对象锁上的其他任意一个线程
        }
    }
}