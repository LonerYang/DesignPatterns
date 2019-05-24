package com.ahead.proxy.v7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * v1问题：我想记录坦克的移动时间
 * v2最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变源码呢?
 * v3用继承？
 * 		要慎用继承因为后面如果又有需求又用继承，最终这个继承体系将会非常庞大，
 * 		修改父类的一个属性所有子类继承的属性都会改变
 * v4 使用代理(静态代理)
 * v5 代理有各种类型
 *    如何实现代理的各种组合呢？使用Decorator？
 * v6 将代理类中的Tank引用改成Moveable
 *    静态代理最终版
 * v7 如果是Tank的stop方法需要代理呢
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型
 * 		如果将成员变量Movable改为Object这个问题就麻烦了
 * （毕竟日志记录，时间计算是很多方法都需要的东西），这时该怎么做呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
 * @author Yang
 * @version 1.0
 * @time 2019/5/24
 */
public class Tank implements Movable {

	/**
	 * 模拟坦克移动了一段时间
	 */
	@Override
	public void move() {
		System.out.println("Tank moving claclacla...");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//在运行的时候动态的通过asm加载字节码并创建代理对象
		//param1：哪个类加载器把代理类load到内存
		//param2：代理类要实现的接口
		//param3：代理行为：被代理对象调用方法时需要做什么处理
		Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
				//相当于前面的TankLogProxy代理类要实现Movable接口
				Tank.class.getInterfaces(),
				new TankLogHandlder(new Tank()));
		movable.move();
	}
}

class TankLogHandlder implements InvocationHandler {

	Tank tank;

	TankLogHandlder(Tank tank) {
		this.tank = tank;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Tank move");
		Object o = method.invoke(tank, args);
		System.out.println("Tank stop");
		return o;
	}
}

interface Movable {
	void move();
}