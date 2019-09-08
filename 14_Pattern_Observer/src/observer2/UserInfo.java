package observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * @description:
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public class UserInfo implements Observer {
    private String name;
    public UserInfo(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("["+name+"]收到消息："+((MessageInfo)o).getMessage());
    }
}
