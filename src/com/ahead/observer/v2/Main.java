package com.ahead.observer.v2;

/**
 * 加入观察者
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
class Child {
	private boolean cry = false;

	private Dad dad = new Dad();

	public void wakeUP() {
		cry = true;
		System.out.println("Waked Up! Crying wuwuwu...");
		dad.feed();
	}

	public boolean isCry() {
		return cry;
	}


}

class Dad {
	public void feed() {
		System.out.println("Dad is feeding...");
	}

}
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		child.wakeUP();
	}
}