package com.ahead.proxy.v1;

import java.util.Random;

/**
 * v1问题：我想记录坦克的移动时间
 * @author Yang
 * @version 1.0
 * @time 2019/5/24
 */
public class Tank implements Movable  {

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
}

interface Movable {
	void move();
}
