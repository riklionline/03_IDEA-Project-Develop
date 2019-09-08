package observer;

/**
 * @description:
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public class TestDemo {

    public static void main(String[] args) {
        Message message = new Message();//生成被观察者
        //生成3个用户
        Observer user1 = new User("lily");
        Observer user2 = new User("tom");
        Observer user3 = new User("vince");
        Observer user4 = new User("YG");
        //把3个用户注册成为message对象的观察者
        message.registerObserver(user1);
        message.registerObserver(user2);
        message.registerObserver(user3);
        //改变消息（广播消息）
        message.setMessage("亲们，么么哒");

        //取消user1作为观察者
        message.removeObserver(user1);

        message.setMessage("有在的吗，我要发红包啦");

    }

}
