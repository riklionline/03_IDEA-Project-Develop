package com.remcal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器
 */
public class Server {
    public static void main(String[] args) {
        /*
        * 创建线程池存储空间（Vector:，向量，一种数据结构类型）
        * 用以保存客户端处理的线程，等待使用
        * 因为客户端可能同时运行N个，并且它们之间需要互相访问交互信息
        */
        Vector<UserThread> vector = new Vector<>();
        /**
         * 创建真正的线程池,可同时执行4个线程，标志着可以同时运行4个客户端
         */
        ExecutorService es = Executors.newFixedThreadPool(4);
        /*
        * 创建服务器端的Socket，用以接收来自客户端的数据
        * 创建完成标志着服务器已经启动，因为已经提供出了通讯数据包
        */
        try {
            ServerSocket server = new ServerSocket(9595);
            System.out.println("服务器已启动，等待客户端连接……");
            while(true){
                Socket socket = server.accept();
                UserThread user = new UserThread(socket,vector);//创建用户线程对象，传入参数
                vector.add(user);//每次创建一个用户线程都需要将其加入线程池中，以便于线程之间的交互
                es.execute(user);//开启用户线程
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 创建user线程类，注意只有客户端数据包需要放入线程中，所以只有客户端线程类
 */
class  UserThread implements  Runnable{
    private  String name;//客户端用户名称，唯一
    private Socket socket;
    Vector<UserThread> vector;//客户端处理线程的集合，使其共用一个集合，因为线程之间需要交互

    private ObjectInputStream ois;//定义对象输入流，流过来的数据是未知类型，所以定义成对象流
    private ObjectOutputStream oos;//定义对象输出流，流出去的数据是未知类型，所以定义成对象流
    private boolean flag = true;

    public UserThread(Socket socket,Vector<UserThread> vector){
        this.socket = socket;
        this.vector = vector;
    }
    @Override
    public void run() {
        try {
            System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已链接");//获取当前用户主机IP地址
            ois = new ObjectInputStream(socket.getInputStream());//将用户socket数据包中的数据转成对象输入流格式
            oos = new ObjectOutputStream(socket.getOutputStream());//将用户socket数据包中的数据转成对象输出流格式

            while (flag){

                Message msg = (Message)ois.readObject();//获取消息强制转换成message类型
                int type = msg.getType();
                switch (type){//基于消息类型分别处理

                    case MessageType.TYPE_SEND:
                        String to = msg.getTo();//获取发送目标名称
                        UserThread ut;
                        int size = vector.size();
                        for (int i = 0; i < size; i++) {
                            ut = vector.get(i);
                            if(to.equals(ut.name)&&ut!=this){//在线程池集合中遍历用户线程，找到目标对象名称
                                ut.oos.writeObject(msg);//找到目标名称立即发出消息
                                break;
                            }
                        }
                    break;
                    case MessageType.TYPE_LOGIN:
                        name = msg.getFrom();//消息发送者名称存储
                        msg.setInfo("欢迎你：");//消息内容存储
                        oos.writeObject(msg);//当前消息数据包写入对象输出流，这样才能从服务器发出
                    break;
                }
            }
            ois.close();//关闭对象输入流
            oos.close();//关闭对象输出流

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
