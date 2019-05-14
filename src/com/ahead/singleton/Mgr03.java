package com.ahead.singleton;
/**
 *  使用静态内部类达到懒加载的单例
 * @author Yang
 *
 */
public class Mgr03 {
	
	private static class Inner {
		private static Mgr03 INSTANCE = new Mgr03();
	}
	
	public static Mgr03 getInstance() {
		//只有执行到这里内部类才会加载，这时候才会创建对象
		return Inner.INSTANCE;
	}
	
	private Mgr03() {}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Mgr03.getInstance())).start();
		}
	}

}
