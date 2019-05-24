package com.ahead.proxy.v4;

import java.util.Random;

/**
 * v1问题：我想记录坦克的移动时间
 * v2最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变源码呢?
 * v3用继承？
 * 		要慎用继承因为后面如果又有需求又用继承，最终这个继承体系将会非常庞大，
 * 		修改父类的一个属性所有子类继承的属性都会改变
 * v4使用代理(静态代理)
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
		new TankTimeProxy(new Tank()).move();
	}
}

class TankTimeProxy implements Movable {

	private Tank tank;

	TankTimeProxy(Tank tank) {
		this.tank = tank;
	}

	@Override
	public void move() {
		long start = System.currentTimeMillis();
		tank.move();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}

interface Movable {
	void move();
}