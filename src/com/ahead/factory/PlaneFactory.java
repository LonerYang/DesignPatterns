package com.ahead.factory;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/11
 */
public class PlaneFactory implements VehicleFactory {

	private static PlaneFactory planeFactory = new PlaneFactory();

	public static VehicleFactory getInstance() {
		return planeFactory;
	}


	private PlaneFactory() {}

	@Override
	public Vehicle create() {
		return new Plane();
	}
}
