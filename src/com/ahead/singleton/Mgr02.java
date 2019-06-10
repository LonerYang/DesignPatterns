package com.ahead.singleton;
/**
 * 懒汉式
 * @author Yang
 *
 */
public class Mgr02 {
	/**
	 * 采用 volatile 关键字修饰也是很有必要的， INSTANCE = new Mgr02(); 这段代码其实是分
	 * 为三步执行：
	 * 1. 为 INSTANCE 分配内存空间
	 * 2. 初始化 INSTANCE
	 * 3. 将 INSTANCE 指向分配的内存地址
	 * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出先问题，但是在
	 * 多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用
	 * getInstance() 后发现 INSTANCE 不为空，因此返回 INSTANCE，但此时 INSTANCE 还未被
	 * 初始化。
	 * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
	 */
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
