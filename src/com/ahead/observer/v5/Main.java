package com.ahead.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来处理; 抽取事件类
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
		WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");
		if (!observers.isEmpty()) {
			for (Observer obServer : observers) {
				obServer.actionOnWakeUp(event);
			}
		}
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
}

class WakeUpEvent {
	long timestamp;
	String location;
	
	WakeUpEvent(long timestamp, String location) {
		this.timestamp = timestamp;
		this.location = location;
	}
}

interface Observer {
	void actionOnWakeUp(WakeUpEvent wakeUpEvent);
}

class Dad implements Observer {

	public void feed() {
		System.out.println("Dad feeding...");
	}

	@Override
	public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
		feed();
	}
}

class Mum implements Observer {

	public void hug() {
		System.out.println("Mum hugging...");
	}

	@Override
	public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
		hug();
	}
}

class Dog implements Observer {

	public void wang() {
		System.out.println("Dog wang...");
	}

	@Override
	public void actionOnWakeUp(WakeUpEvent wakeUpEvent) {
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