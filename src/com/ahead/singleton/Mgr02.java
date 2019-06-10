package com.ahead.singleton;
/**
 * 懒汉式
 * @author Yang
 *
 */
public class Mgr02 {
	
	private volatile static Mgr02 INSTANCE = null;

	public static Mgr02 getInstance() {
		//双重检查，外面的判断不能省略，如果省略了，每个线程过来都要拿锁，浪费很多效率
		if (INSTANCE == null) {
			synchronized(Mgr02.class) {
				if (INSTANCE == null) {
					INSTANCE = new Mgr02();
				}
			}
		}
		return INSTANCE;
	}
	
	private Mgr02() {}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Mgr02.getInstance())).start();
		}
	}
}
