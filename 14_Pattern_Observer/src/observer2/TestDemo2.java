package observer2;

/**
 * @description:
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public class TestDemo2 {
    public static void main(String[] args) {
        MessageInfo messageInfo = new MessageInfo();
        UserInfo user1 = new UserInfo("lilei");
        UserInfo user2 = new UserInfo("vince");
        UserInfo user3 = new UserInfo("hanmeimei");

        messageInfo.addObserver(user1);
        messageInfo.addObserver(user2);
        messageInfo.addObserver(user3);

        messageInfo.setMessage("亲们，么么哒");


        messageInfo.deleteObserver(user2);
        messageInfo.setMessage("韩梅梅和李雷！你们结婚了吗？");
    }
}
