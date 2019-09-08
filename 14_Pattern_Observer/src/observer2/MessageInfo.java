package observer2;

import java.util.Observable;

/**
 * @description:
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public class MessageInfo extends Observable {
    private String message;

    public void setMessage(String message) {
        if (this.message!=message){
            this.message = message;
            setChanged();//设置标记，true表示要更新，false表示不更新
        }
        notifyObservers();//通知所有的观察者，但changed必须是true，否则将不通知
    }

    public String getMessage() {
        return message;
    }
}
