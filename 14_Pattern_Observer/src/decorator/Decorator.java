package decorator;

/**
 * 装饰者的基类
 * @author vince
 * @description
 */
public abstract class Decorator implements Drink{
	private Drink drink;//要装饰的对象
	public Decorator(Drink drink){
		this.drink = drink;
	}
	@Override
	public float cost() {
		return drink.cost();//返回被装饰者的价格
	}

	@Override
	public String description() {
		return drink.description();
	}

}
