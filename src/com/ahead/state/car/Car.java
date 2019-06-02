package com.ahead.state.car;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/5/29
 */
public class Car {
	private CarState carState;
	
	public Car(CarState carState) {
		this.carState = carState;
	}
	
	public void openDoor() {
		carState.openDoor();
	}

	
	public void closeDoor() {
		carState.closeDoor();
	}

	
	public void runCar() {
		carState.runCar();
	}

	
	public void stopCar() {
		carState.stopCar();
	}	
}
