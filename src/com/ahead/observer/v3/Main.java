package com.ahead.observer.v3;

/**
 * 加入多个观察者
 * 事件源：Child
 * 事件：wakeUp
 * 观察者：Dad、Mum、Dog
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
class Child {
	private boolean cry = false;
	private Dad dad = new Dad();
	private Mum mum = new Mum();
	private Dog dog = new Dog();

	public boolean isCry() {
		return cry;
	}

	public void wakeUp() {
		cry = true;
		System.out.println("Waked Up! Crying wuwuwu...");
		dad.feed();
		dog.wang();
		mum.hug();
	}

}

class Dad {
	public void feed() {
		System.out.println("Dad feeding...");
	}
}

class Mum {
	public void hug() {
		System.out.println("Mum hugging...");
	}
}

class Dog {
	public void wang() {
		System.out.println("Dog wang...");
	}
}
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		child.wakeUp();
	}
}