package observer;

// 我们在设计一个多个类结构时，我们要让具体的两个类之间的依赖，转换成两个抽象的依赖（解耦）
/**
 * @description: 被观察者的接口
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public interface MessageSubject {
    //注册观察者（把一个对象添加为此主题的观察者）
    public void registerObserver(Observer o);
    //移除观察者
    public void removeObserver(Observer o);
    //通知所有观察者
    public void notifyObservers();
}
