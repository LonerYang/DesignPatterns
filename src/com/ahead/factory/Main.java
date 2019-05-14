package com.ahead.factory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class Main {
	public static void main(String[] args) {
		Vehicle vehicle = PlaneFactory.getInstance().create();
		vehicle.go();
	}
}
