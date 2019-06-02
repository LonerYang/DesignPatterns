package com.ahead.state.car;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Stoped implements CarState {
	@Override
	public void openDoor() {
		System.out.println("open the door");
	}

	@Override
	public void closeDoor() {
		System.out.println("NO!!!");
	}

	@Override
	public void runCar() {
		System.out.println("run the car");
	}

	@Override
	public void stopCar() {
		System.out.println("NO!!!");
	}
}
