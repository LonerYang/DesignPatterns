package com.ahead.templateMethod;

/**
 * 模板方法模式
 * 	-在Frame类中也用到了，Frame中调用了paint()，但是没有给出实现，我们实现Frame类，重写paint(),这时候paint()会被自动调用
 * 	-也叫钩子函数
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Main {
	public static void main(String[] args) {
		F f = new C();
		f.init();
	}
}

abstract class F {
	public void init() {
		m1();
		m2();
	}

	abstract void m1();

	abstract void m2();
}

class C extends F {

	@Override
	void m1() {
		System.out.println("C m1");
	}

	@Override
	void m2() {
		System.out.println("C m2");
	}
}