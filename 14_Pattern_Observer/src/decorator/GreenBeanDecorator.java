package decorator;

/**
 * @description:
 * @comp: http://www.codingke.com
 * @author: 威哥
 * @威哥QQ: 2982314633
 */
public class GreenBeanDecorator extends Decorator {
    public GreenBeanDecorator(Drink drink) {
        super(drink);
    }

    @Override
    public float cost() {
        return super.cost()+2f;
    }

    @Override
    public String description() {
        return super.description()+"+绿豆";
    }
}
