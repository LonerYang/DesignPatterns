package com.ahead.observer.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与事件源
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
class Child {
	private boolean cry = false;
	private List<Observer> observers = new ArrayList<>();


	public boolean isCry() {
		return cry;
	}

	public void wakeUp() {
		cry = true;
		System.out.println("Waked Up! Crying wuwuwu...");
		if (!observers.isEmpty()) {
			for (Observer obServer : observers) {
				obServer.actionOnWakeUp();
			}
		}
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}
}

interface Observer {
	void actionOnWakeUp();
}
class Dad implements Observer {

	public void feed() {
		System.out.println("Dad feeding...");
	}

	@Override
	public void actionOnWakeUp() {
		feed();
	}
}

class Mum implements Observer {

	public void hug() {
		System.out.println("Mum hugging...");
	}

	@Override
	public void actionOnWakeUp() {
		hug();
	}
}

class Dog implements Observer {

	public void wang() {
		System.out.println("Dog wang...");
	}

	@Override
	public void actionOnWakeUp() {
		wang();
	}
}
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		child.addObserver(new Dad());
		child.addObserver(new Mum());
		child.addObserver(new Dog());
		child.wakeUp();

	}
}