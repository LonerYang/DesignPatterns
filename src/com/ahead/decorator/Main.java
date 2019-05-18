package com.ahead.decorator;

/**
 * 模拟咖啡
 * 1、抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2、具体组件：需要装饰的对象
 * 3、抽象装饰类（对装饰类的）：包含了对抽象组件的引用以及装饰者共有的方法
 * 4、具体装饰类：给具体组件添加装饰
 *
 * @author Yang
 * @version 1.0
 * @time 2019/5/18
 */

/**
 * 抽象组件
 */
interface Drink {
	/**
	 * 返回饮料的价格
	 *
	 * @return
	 */
	int cost();

	/**
	 * 返回饮料的信息
	 */
	String info();
}

public class Main {
	public static void main(String[] args) {
		Drink drink = new Milk(new Sugr(new Coffee()));
		System.out.println(drink.cost());
		System.out.println(drink.info());
	}
}

/**
 * 具体组件
 */
class Coffee implements Drink {

	@Override
	public int cost() {
		return 10;
	}

	@Override
	public String info() {
		return "普通咖啡";
	}
}

/**
 * 抽象装饰类
 */
abstract class DrinkDecorator implements Drink {
	private Drink drink;

	DrinkDecorator(Drink drink) {
		this.drink = drink;
	}

	@Override
	public int cost() {
		return drink.cost();
	}

	@Override
	public String info() {
		return drink.info();
	}
}

/**
 * 具体装饰类
 */
class Milk extends DrinkDecorator {

	Milk(Drink drink) {
		super(drink);
	}

	@Override
	public int cost() {
		return super.cost() + 5;
	}

	@Override
	public String info() {
		return super.info() + " 加奶";
	}

}

/**
 * 具体装饰类
 */
class Sugr extends DrinkDecorator {

	Sugr(Drink drink) {
		super(drink);
	}

	@Override
	public int cost() {
		return super.cost() + 2;
	}

	@Override
	public String info() {
		return super.info() + " 加糖";
	}

}