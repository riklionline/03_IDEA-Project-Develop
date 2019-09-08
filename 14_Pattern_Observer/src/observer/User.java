package observer;

/**
 * 具体的观察者
 */
public class User implements Observer {
    private String name;
    public User(String name){
        this.name = name;
    }
    //这个方法是给被观察者通知时调用
    @Override
    public void update(String message) {
        System.out.println("["+name+"]收到消息："+message);
    }
}
