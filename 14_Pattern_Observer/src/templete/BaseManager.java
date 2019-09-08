package templete;

/**
 * @description: 模板方法的父类（抽象类），定义一个方法骨架（算法）
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public abstract class BaseManager {
    //模板
    public void action(String name,String method){
        if("admin".equals(name)){
            execute(method);//由子类来提供具体的实现
        }else{
            System.out.println("你没有操作权限，请联系管理员");
        }
    }
    //定义一个抽象方法
    public abstract void execute(String method);
}
