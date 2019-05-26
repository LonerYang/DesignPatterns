package com.ahead.singleton;
/**
 * 	枚举的方式实现单例，而且不能反序列化
 * @author Yang
 *
 */
public enum Mgr04 {

	/**
	 * 实例
	 */
	INSTANCE;
	
	public static Mgr04 getInstance() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Mgr04.getInstance().hashCode())).start();
		}
	}
}
