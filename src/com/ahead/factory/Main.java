package com.ahead.factory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class Main {
	public static void main(String[] args) {
		VehicleFactory planeFactory = PlaneFactory.getInstance();
		Vehicle plane = planeFactory.create();
		plane.go();

		VehicleFactory carFactory = CarFactory.getInstance();
		Vehicle car = carFactory.create();
		car.go();
	}
}