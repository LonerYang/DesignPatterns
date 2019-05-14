package com.ahead.singleton;

public class Mgr01 {
	
	private static Mgr01 INSTANCE = new Mgr01();

	public static Mgr01 getInstance() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return INSTANCE;
	}
	
	private Mgr01() {}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Mgr01.getInstance())).start();
		}
	}
}
