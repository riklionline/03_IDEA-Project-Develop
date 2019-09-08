package decorator;

/**
 * 测试类
 */
public class Test {

	public static void main(String[] args) {

//		OutputStream out = new FileOutputStream("xxx");
//		BufferedOutputStream bos = new BufferedOutputStream(out);
//		PrintStream ps = new PrintStream(bos);
//		ps.print(..);

		Drink drink = new SoyaBeanMilk();// 生产一杯纯豆浆
		//豆浆加糖
		Drink sugarDrink = new SugarDecorator(drink);
		//糖豆浆加鸡蛋
		Drink sugarEggDrink = new EggDecorator(sugarDrink);
		//糖鸡蛋豆浆加黑豆
		Drink blackBeanSugarEggDrink = new BlackBeanDecorator(sugarEggDrink);
		//黑豆糖鸡蛋豆浆加绿豆
		Drink greenBlackBeanSugarEggDrink = new GreenBeanDecorator(blackBeanSugarEggDrink);

		System.out.println("你点的豆浆是："+greenBlackBeanSugarEggDrink.description());
		System.out.println("一共花了"+greenBlackBeanSugarEggDrink.cost()+"元");
	}

}
