package decorator;

/**
 * 具体的被装饰者类
 * 豆浆
 * @author vince
 * @description
 */
public class SoyaBeanMilk implements Drink{
	//对象本身只关注自己
	@Override
	public float cost() {
		return 10f;
	}

	@Override
	public String description() {
		return "纯豆浆";
	}

}
