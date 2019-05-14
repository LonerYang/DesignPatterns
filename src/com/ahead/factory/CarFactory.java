package com.ahead.factory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class CarFactory implements VehicleFactory {

	private static CarFactory carFactory;

	public static CarFactory getInstance() {
		if (carFactory == null) {
			synchronized (CarFactory.class) {
				if (carFactory == null) {
					carFactory = new CarFactory();
				}
			}
		}
		return carFactory;
	}

	private CarFactory() {}

	@Override
	public Vehicle create() {
		return new Car();
	}
}
