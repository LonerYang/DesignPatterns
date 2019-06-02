package com.ahead.state.car;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Running implements CarState {
	@Override
	public void openDoor() {
		System.out.println("NO!!!");
	}

	@Override
	public void closeDoor() {
		System.out.println("NO!!!");
	}

	@Override
	public void runCar() {
		System.out.println("NO!!!");
	}

	@Override
	public void stopCar() {
		System.out.println("stop the car");
	}
}
