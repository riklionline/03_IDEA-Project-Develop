package com.strategypattern;

public class TopUp {
    public static void main(String[] args) {
        TopUpService userTopUp =new UserService();
        userTopUp.setITopUp(new Members());
        userTopUp.topStart(85.5);
    }
}

interface ITopUp{
    public void topup(Double data);
}

class Members implements ITopUp{
    @Override
    public void topup(Double data) {
        System.out.println("正在充值"+data*(100.0/97.0)+"元");
    }
}
class SuperMembers implements ITopUp{
    @Override
    public void topup(Double data) {
        System.out.println("正在充值"+data*(100.0/92.0)+"元");
    }
}
abstract class TopUpService{
    private ITopUp iTopUp;
    public void setITopUp(ITopUp iTopUp){
         this.iTopUp=iTopUp;
    }
    public void topStart(Double data){
        System.out.println("开始充值……");
        this.iTopUp.topup(data);//前边是谁充值,后面是充多少
        System.out.println("充值完成！");
    }
}
class UserService extends TopUpService{

}