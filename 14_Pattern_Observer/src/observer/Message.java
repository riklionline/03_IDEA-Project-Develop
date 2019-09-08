package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @description: 订阅模式（）
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public class Message implements MessageSubject{
    //维护的观察者列表
    private List<Observer> list = new Vector<>();

    private String message;//消息数据

    //改变消息的方法
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();//通过所有的观察者
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (int i=0;i<list.size();i++){
            Observer observer = list.get(i);
            observer.update(message);
        }
    }
}
