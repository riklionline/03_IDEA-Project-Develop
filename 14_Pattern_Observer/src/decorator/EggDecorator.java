package decorator;

/**
 * 具体的装饰者类
 * @author vince
 * @description
 */
public class EggDecorator extends Decorator {

	public EggDecorator(Drink drink) { //要装饰在哪个对象上
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost()+3.0f;
	}

	@Override
	public String description() {
		return super.description()+"+鸡蛋";
	}

}
