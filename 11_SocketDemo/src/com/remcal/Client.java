package com.remcal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ExecutorService es = Executors.newSingleThreadExecutor();//创建单线程池

        try {
            Socket socket = new Socket("localhost",9595);
            System.out.println("服务器连接成功");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            /*向服务器发送登陆信息*/
            System.out.println("请输入名称：");
            String name = input.nextLine();
            Message msg = new Message(name,null,MessageType.TYPE_LOGIN,null);//创建登陆消息，对号入座传参
            oos.writeObject(msg);//向服务器发出数据包
            msg = (Message)ois.readObject();//服务器返回数据包（服务器如果没有设定返回数据包的机制怎么办？？？）
            System.out.println(msg.getInfo()+msg.getFrom());//将刚刚从服务器获取的信息打印出来

            /*1)启动读取消息的线程，注意是持续获取信息,所以需要放到线程中*/
            es.execute(new ReadInfoThread(ois));//开启信息读取的线程

            /*2)启动发送消息的主线程，进入循环*/
            boolean flag = true;
            while (flag){

                /*封装消息数据包*/
                msg = new Message();//先创建一个message消息对象
                System.out.println("To:");
                msg.setTo(input.nextLine());//消息接收者名称
                msg.setFrom(name);//消息发送者名称
                msg.setType(MessageType.TYPE_SEND);//设置消息类型
                System.out.println("Info:");
                msg.setInfo(input.nextLine());

                oos.writeObject(msg);//将封装好的消息数据包发出

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class ReadInfoThread implements  Runnable{
    private ObjectInputStream in;

    public ReadInfoThread(ObjectInputStream in) {
        this.in = in;
    }

    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            while(flag){

                Message message = (Message) in.readObject();
                System.out.println("["+message.getFrom()+"]对我说："+message.getInfo());//将接收到的信息打印出来
            }
            if(in!=null){
                in.close();//如果输入流不为空，说明读入完成，关闭输入流
            }
        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}