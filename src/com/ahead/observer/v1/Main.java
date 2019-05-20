package com.ahead.observer.v1;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/20
 */
class Child {
	private boolean cry = false;

	public boolean isCry() {
		return cry;
	}

	public void wakeUP() {
		System.out.println("Waked Up! Crying wuwuwu...");
		cry = true;
	}


}
public class Main {
	public static void main(String[] args) {
		Child child = new Child();
		//如果没有在哭就一直观察
		while(!child.isCry()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("observing");
		}
	}
}
